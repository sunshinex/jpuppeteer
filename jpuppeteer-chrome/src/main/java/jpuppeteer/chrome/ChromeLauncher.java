package jpuppeteer.chrome;

import jpuppeteer.api.browser.Launcher;
import jpuppeteer.cdp.CDPConnection;
import jpuppeteer.cdp.WebSocketCDPConnection;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChromeLauncher implements Launcher {

    private static final Logger logger = LoggerFactory.getLogger(ChromeLauncher.class);

    private static final Pattern LISTENING_PATTERN = Pattern.compile("^DevTools listening on (ws:\\/\\/.*)$");

    private final String executable;

    private volatile Process process;

    private volatile ChromeBrowser browser;

    private volatile ChromeArguments chromeArguments;

    public ChromeLauncher(String executable) {
        this.executable = executable;
    }

    @Override
    public ChromeBrowser launch(String... args) throws Exception {
        chromeArguments = ChromeArguments.parse(executable, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (browser != null && process != null && process.isAlive()) {
                    browser.close();
                    logger.info("normally quit browser succeed");
                    //等待chrome进程退出
                    while (process.isAlive()) {
                        logger.info("chrome process is alive, waiting...");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    logger.info("chrome process is normally terminated");
                }
            } catch (Exception e) {
                logger.error("normally quit browser failed, error={}", e.getMessage(), e);
            } finally {
                if (process != null && process.isAlive()) {
                    process.destroy();
                    logger.info("chrome process is terminated");
                }
            }
            if (chromeArguments.isUseTempUserData()) {
                //删除临时文件夹
                File tmp = new File(chromeArguments.getUserDataDir());
                if (tmp.exists()) {
                    logger.debug("clean user data dir {}", chromeArguments.getUserDataDir());
                    delete(tmp);
                    logger.debug("clean success {}", chromeArguments.getUserDataDir());
                }
            }
        }));
        String[] command = chromeArguments.getCommand();
        File exec = new File(executable);
        logger.info("command line: {}", StringUtils.join(command, " "));
        process = Runtime.getRuntime().exec(command, null, exec.getParentFile());
        CDPConnection connection;
        URI uri;
        if (!chromeArguments.isPipe()) {
            //等待chrome启动成功的debug listening输出
            uri = waitForListening();
            connection = new WebSocketCDPConnection(uri);
            connection.open();
        } else {
            throw new Exception("unsupport pipe debug mode");
        }
        //启动线程记录subprocess stderr的输出
        new Thread("CHROME-STDERR-LOG-THREAD") {
            @Override
            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while (process.isAlive()) {
                    try {
                        String line = reader.readLine();
                        if (StringUtils.isNotEmpty(line)) {
                            logger.debug("chrome process stderr message={}", line);
                        }
                    } catch (IOException e) {
                        logger.error("chrome process stderr read error, error={}", e.getMessage(), e);
                    }
                }
            }
        }.start();
        browser = new ChromeBrowser(uri.getHost() + ":" + uri.getPort(), process, connection);
        return browser;
    }

    private void delete(File file) {
        if (file.isDirectory()) {
            for(File f : file.listFiles()) {
                delete(f);
            }
        }
        file.delete();
    }

    private URI waitForListening() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            Matcher matcher = LISTENING_PATTERN.matcher(line);
            if (matcher.matches()) {
                logger.info(line);
                return URI.create(matcher.group(1));
            }
        }
        throw new RuntimeException("please ensure startup with arg --remote-debugging-pipe or --remote-debugging-port");
    }
}
