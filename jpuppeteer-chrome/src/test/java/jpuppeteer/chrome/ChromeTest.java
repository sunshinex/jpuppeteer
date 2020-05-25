package jpuppeteer.chrome;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.chrome.event.page.FrameResponse;
import jpuppeteer.chrome.event.page.PageEvent;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ChromeTest {

    private static final Logger logger = LoggerFactory.getLogger(ChromeTest.class);

    @BeforeClass
    public static void setUp() {
        LoggerContext logger = (LoggerContext) LoggerFactory.getILoggerFactory();
        logger.getLogger("root").setLevel(Level.INFO);
    }

    @Test
    public void testInterceptor() throws Exception {
        ChromeBrowser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        ChromePage page = browser.defaultContext().newPage();
        page.enableRequestInterception((request) -> {
            try {
                request.continues();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "*");
        page.addListener(new AbstractListener<FrameResponse>() {
            @Override
            public void accept(FrameResponse response) {
                try {
                    System.out.println(new String(response.content()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        page.navigate("https://item.m.jd.com/product/819163.html");
        TimeUnit.DAYS.sleep(1);
    }

}
