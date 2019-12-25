package jpuppeteer.chrome;

import jpuppeteer.cdp.CDPEvent;
import jpuppeteer.cdp.cdp.CDPEventType;
import jpuppeteer.chrome.event.type.ChromeContextEvent;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

    @Test
    public void test() throws Exception {
        ChromeBrowser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        ChromeContext context = browser.defaultContext();
        context.addListener(ChromeContextEvent.NEWPAGE, (ChromePage page) ->{
            System.out.println(page);
        });
        context.newPage();
        System.out.println(browser.defaultContext().pages().length);
        System.gc();
        System.out.println(browser.defaultContext().pages().length);
        //ChromeContext context = browser.defaultContext();
        //ChromePage page = context.newPage();
        //page.navigate("https://www.baidu.com");
        TimeUnit.DAYS.sleep(1);
    }

}
