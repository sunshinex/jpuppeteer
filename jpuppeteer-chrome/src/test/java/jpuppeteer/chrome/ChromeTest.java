package jpuppeteer.chrome;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.google.common.collect.Lists;
import jpuppeteer.api.browser.Frame;
import jpuppeteer.api.browser.Header;
import jpuppeteer.api.browser.Request;
import jpuppeteer.api.constant.RequestStage;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.cdp.constant.PageLifecyclePhase;
import jpuppeteer.chrome.event.page.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

    private static final Logger logger = LoggerFactory.getLogger(ChromeTest.class);

    private ChromeBrowser browser;

    @Before
    public void setUp() throws Exception {
        LoggerContext logger = (LoggerContext) LoggerFactory.getILoggerFactory();
        logger.getLogger("root").setLevel(Level.INFO);
        browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
    }

    @After
    public void tearDown() throws Exception {
        browser.close();
    }

    @Test
    public void testInterceptor() throws Exception {
        ChromePage page = browser.defaultContext().newPage();
//        page.addListener(new AbstractListener<FrameLifecycle>() {
//            @Override
//            public void accept(FrameLifecycle frameLifecycle) {
//                PageLifecyclePhase phase = frameLifecycle.phase();
//                Frame frame = frameLifecycle.frame();
//                try {
//                    if (frame.url() != null && frame.url().getPath().equals("/mini_login.htm") && PageLifecyclePhase.LOAD.equals(phase)) {
//                        System.out.println(frame.querySelector("#fm-sms-login-id"));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        page.addListener(new AbstractListener<PageCrashed>() {
//            @Override
//            public void accept(PageCrashed crashEvent) {
//                System.out.println(crashEvent.error());
//            }
//        });
        page.enableResponseInterception(request -> {
            try {
                System.out.println(request.headers());
                System.out.println("----------------------------------");
                request.respond(404);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        page.navigate("http://www.baidu.com/");
        TimeUnit.DAYS.sleep(1);
    }

}
