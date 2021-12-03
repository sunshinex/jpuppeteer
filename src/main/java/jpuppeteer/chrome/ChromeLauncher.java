package jpuppeteer.chrome;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.google.common.util.concurrent.SettableFuture;
import com.sun.xml.internal.bind.v2.util.StackRecorder;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.Launcher;
import jpuppeteer.api.Page;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.page.DialogEvent;
import jpuppeteer.api.event.page.LoadedEvent;
import jpuppeteer.api.event.page.NewPageEvent;
import jpuppeteer.api.event.page.PageEvent;
import jpuppeteer.cdp.client.entity.target.TargetInfo;
import jpuppeteer.util.CookieParamBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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
            String uri = future.get(30, TimeUnit.SECONDS);
            return new ChromeBrowser(uri, process);
        } catch (Throwable cause) {
            errThread.interrupt();
            process.destroy();
            throw cause;
        }
    }

    public static ChromeBrowser launch(String uri) throws Exception {
        return new ChromeBrowser(uri, null);
    }

    public static ChromePage attach(String strUri) throws Exception {
        EventLoop eventLoop = new NioEventLoopGroup(1, r -> {
            return new Thread(r, "browser");
        }).next();
        URI uri = URI.create(strUri);
        String[] pathSeg = uri.getPath().split("/");
        String targetId = pathSeg[pathSeg.length - 1];
        TargetInfo targetInfo = new TargetInfo(
                targetId, "page", "", "",
                false, false
        );
        ChromePage page = new WebViewPage(uri, targetInfo, null, eventLoop) {
            @Override
            public Future close() {
                return GlobalEventExecutor.INSTANCE.submit(() -> {
                    try {
                        super.close().get(30, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        logger.error("close webview page failed", e);
                    } finally {
                        eventLoop.shutdownGracefully();
                    }
                });
            }
        };
        page.attach();
        return page;
    }

    private static class WebViewPage extends ChromePage {

        private final EventLoop eventLoop;

        public WebViewPage(URI uri, TargetInfo targetInfo, ChromePage opener, EventLoop eventLoop) {
            super(null, uri, targetInfo, opener);
            this.eventLoop = eventLoop;
        }

        public WebViewPage(TargetInfo targetInfo, ChromePage opener, EventLoop eventLoop) {
            super(null, targetInfo, opener);
            this.eventLoop = eventLoop;
        }

        @Override
        protected EventLoop eventLoop() {
            return eventLoop;
        }

        @Override
        protected ChromePage newOpener(TargetInfo info) {
            return new WebViewPage(info, null, eventLoop);
        }
    }
}
