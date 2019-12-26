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
//        page.addListener(ChromePageEvent.LOAD, event -> {
//            try {
//                page.reload();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        page.addListener(ChromePageEvent.FRAMEDETACHED, (ChromeFrame frame) -> {
//            System.out.println(frame);
//        });
        page.addListener(ChromePageEvent.REQUEST, (Request request) -> {
            System.out.println(request.getRequestId());
        });
        page.addListener(ChromePageEvent.FRAMENAVIGATED, (ChromeFrame frame) -> {
            System.out.println(frame);
        });
        page.navigate("https://www.baidu.com/");
//        browser.createContext();
//        System.gc();
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
