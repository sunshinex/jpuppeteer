package jpuppeteer.chrome;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import jpuppeteer.chrome.event.Request;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import org.junit.BeforeClass;
import org.junit.Test;
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
                page.reload();
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

}
