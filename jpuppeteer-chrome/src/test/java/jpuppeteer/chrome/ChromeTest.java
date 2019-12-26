package jpuppeteer.chrome;

import jpuppeteer.cdp.cdp.entity.target.TargetInfo;
import jpuppeteer.chrome.event.type.ChromeContextEvent;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ChromeTest {

    @Test
    public void test() throws Exception {
        ChromeBrowser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        ChromeContext defaultContext = browser.createContext();
        defaultContext.addListener(ChromeContextEvent.NEWPAGE, (ChromePage page) -> {
            System.out.println(page);
            page.close();
        });
        defaultContext.defaultPage().addListener(ChromePageEvent.CHANGED, (TargetInfo targetInfo) -> {
            System.out.println(targetInfo);
        });
        //defaultContext.defaultPage().navigate("https://www.jd.com/");

//        context.addListener(ChromeContextEvent.NEWPAGE, (ChromePage page) ->{
//            System.out.println(page);
//        });
//        for(int i=0; i<10; i++) {
//            context.cookies();
//        }
        //ChromeContext context = browser.defaultContext();
        //ChromePage page = context.newPage();
        //page.navigate("https://www.baidu.com");
        TimeUnit.DAYS.sleep(1);
    }

}
