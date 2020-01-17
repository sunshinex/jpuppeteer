package jpuppeteer.chrome;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import jpuppeteer.api.browser.BrowserContext;
import jpuppeteer.chrome.constant.LifecycleEventType;
import jpuppeteer.chrome.event.FrameLifecycleEvent;
import jpuppeteer.chrome.event.Request;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ChromeTest {

    @BeforeClass
    public static void setUp() {
        LoggerContext logger = (LoggerContext) LoggerFactory.getILoggerFactory();
        logger.getLogger("root").setLevel(Level.INFO);
    }

    @Test
    public void test() throws Exception {
        ChromeBrowser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        ChromePage page = browser.defaultContext().defaultPage();
        page.addListener(ChromePageEvent.LOAD, event -> {
            try {
                ChromeElement body = page.waitSelector("body", 1, TimeUnit.SECONDS);
                System.out.println(body.html());
                browser.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        page.addListener(ChromePageEvent.CRASHED, event -> {
            try {
                page.reload();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        page.navigate("https://www.taobao.com/");
        TimeUnit.DAYS.sleep(1);
    }

    @Test
    public void testFrame() throws Exception {
        //https://www.w3school.com.cn/tiy/t.asp?f=html_frame_cols
        ChromeBrowser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        ChromePage page = browser.defaultContext().defaultPage();
        Logger logger = LoggerFactory.getLogger(getClass());
        page.addListener(ChromePageEvent.LIFECYCLEEVENT, (FrameLifecycleEvent event) -> {
            if (!event.getType().equals(LifecycleEventType.DOMCONTENTLOADED)) {
                return;
            }
            try {
                logger.info("id={}, url={}", event.getFrame().executionContext().executionContextId, event.getFrame().url());
                event.getFrame().querySelector("body");
            } catch (Exception e) {
                System.out.println(event.getFrame().frameId());
                e.printStackTrace();
            }
        });
        page.navigate("https://www.w3school.com.cn/tiy/t.asp?f=html_frame_cols");
        TimeUnit.DAYS.sleep(1);
    }

    @Test
    public void testCloseContext() throws Exception {
        ChromeBrowser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        BrowserContext context = browser.createContext();
        context.close();
        browser.defaultContext().close();
        TimeUnit.DAYS.sleep(1);
    }

}
