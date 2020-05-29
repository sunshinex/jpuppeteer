package jpuppeteer.chrome;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.chrome.event.page.FrameResponse;
import jpuppeteer.chrome.event.page.PageEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        page.navigate("https://goods.kaola.com/product/8203697.html");
        TimeUnit.DAYS.sleep(1);
    }

}
