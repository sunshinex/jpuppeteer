package jpuppeteer.chrome;

import com.google.common.util.concurrent.SettableFuture;
import jpuppeteer.api.Browser;
import jpuppeteer.api.Launcher;
import jpuppeteer.cdp.CDPConnection;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChromeLauncher implements Launcher {

    private static final Logger logger = LoggerFactory.getLogger(ChromeLauncher.class);

    private static final Pattern LISTENING_PATTERN = Pattern.compile("^DevTools listening on (ws://.*)$");

    private final String executable;

    public ChromeLauncher(String executable) {
        this.executable = executable;
    }

    @Override
    public Browser launch(String... args) throws Exception {
        ChromeArguments chromeArguments = ChromeArguments.parse(executable, args);
        if (chromeArguments.isPipe()) {
            throw new IllegalArgumentException("unsupported pipe debug mode");
        }
        String[] command = chromeArguments.getCommand();
        File exec = new File(executable);
        logger.info("command line: {}", StringUtils.join(command, " "));
        Process process = Runtime.getRuntime().exec(command, null, exec.getParentFile());

        SettableFuture<String> future = SettableFuture.create();

        Thread errThread = new Thread("CHROME-STDERR-THREAD") {
            @Override
            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while (process.isAlive() && !isInterrupted()) {
                    try {
                        String line = reader.readLine();
                        line = StringUtils.trim(line);
                        if (StringUtils.isEmpty(line)) {
                            continue;
                        }
                        logger.debug(line);
                        if (!future.isDone() && !future.isCancelled()) {
                            Matcher matcher = LISTENING_PATTERN.matcher(line);
                            if (matcher.matches()) {
                                future.set(matcher.group(1));
                            }
                        }
                    } catch (IOException e) {
                        if (!future.isDone() && !future.isCancelled()) {
                            future.setException(e);
                        }
                        logger.error("read error, error={}", e.getMessage(), e);
                    }
                }
            }
        };

        errThread.start();

        try {
            Runtime.getRuntime().addShutdownHook(new Thread(process::destroy));
            //等待5s, 等chrome启动成功, 如果5s没有启动成功, 则强制关闭chrome进程
            String uri = future.get(5, TimeUnit.SECONDS);
            CDPConnection connection = new CDPConnection(uri);
            return new ChromeBrowser(connection);
        } catch (Throwable cause) {
            errThread.interrupt();
            process.destroy();
            throw cause;
        }
    }
}
