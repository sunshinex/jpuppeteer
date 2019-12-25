package jpuppeteer.chrome;

import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.cdp.CDPEventType;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ChromeTest {

    @Test
    public void test() throws Exception {
        ChromeBrowser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        browser.addListener(CDPEventType.TARGET_TARGETCREATED, (CDPEvent event) -> {
            System.out.println(event);
        });
        System.out.println(browser.defaultContext().pages());
        //ChromeContext context = browser.defaultContext();
        //ChromePage page = context.newPage();
        //page.navigate("https://www.baidu.com");
        TimeUnit.DAYS.sleep(1);
    }

}
