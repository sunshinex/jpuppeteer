package jpuppeteer.chrome;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnRequest;
import jpuppeteer.cdp.cdp.entity.runtime.CallFunctionOnResponse;
import jpuppeteer.chrome.event.Request;
import jpuppeteer.chrome.event.RequestFailed;
import jpuppeteer.chrome.event.RequestFinished;
import jpuppeteer.chrome.event.type.ChromeContextEvent;
import jpuppeteer.chrome.event.type.ChromePageEvent;
import org.apache.commons.lang3.BitField;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static jpuppeteer.chrome.ChromeBrowser.DEFAULT_TIMEOUT;

public class ChromeTest {

    @BeforeClass
    public static void setUp() {
        LoggerContext logger = (LoggerContext) LoggerFactory.getILoggerFactory();
        //logger.getLogger("root").setLevel(Level.INFO);
    }

    @Test
    public void test() throws Exception {
        ChromeBrowser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        ChromeContext context = browser.defaultContext();
//        context.addListener(ChromeContextEvent.NEWPAGE, (ChromePage page) -> {
//            try {
//                if (page.opener() == null) {
//                    page.navigate("https://www.baidu.com/");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
        ChromePage page = context.newPage();
        page.addListener(ChromePageEvent.LOAD, event -> {
            try {
                ChromeElement element = page.querySelector("body");
                CallFunctionOnRequest request = new CallFunctionOnRequest();
                request.setFunctionDeclaration("function(){console.log(this);}");
                request.setObjectId(element.objectId);
                request.setUserGesture(true);
                request.setReturnByValue(false);
                request.setAwaitPromise(true);
                CallFunctionOnResponse response = element.executionContext.runtime.callFunctionOn(request, DEFAULT_TIMEOUT);
                System.out.println(response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        page.navigate("https://www.taobao.com/");
        TimeUnit.DAYS.sleep(1);
    }

    @Test
    public void test2() throws Exception {
        System.out.println(new String(Base64.getUrlDecoder().decode("O1CN01HSuppM1zDUIdFXRVH"), "gb2312"));
        System.out.println(new String(Base64.getUrlDecoder().decode("O1CN013cScr81zDUGt5edRh"), "gb2312"));
    }

    @Test
    public void test3() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Users\\jarvis.xu\\Desktop\\tmp.txt"));
        String line;
        ByteBuffer buffer = ByteBuffer.allocate(1452);
        while ((line = reader.readLine()) != null) {
            String[] bits = line.split(" ");
            for(String bit : bits) {
                bit = StringUtils.trim(bit);
                if (StringUtils.isEmpty(bit)) {
                    continue;
                }
                Integer s = Integer.valueOf(bit, 16);
                /*if (s > Byte.MAX_VALUE) {
                    s -= Byte.MAX_VALUE;
                } else if (s < Byte.MIN_VALUE) {
                    s -= Byte.MIN_VALUE;
                }*/
                try {
                    buffer.put(s.byteValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        byte[] bytes = buffer.array();
        FileOutputStream os = new FileOutputStream("D:\\Users\\jarvis.xu\\Desktop\\tmp.gz");
        os.write(bytes);
        os.flush();
        os.close();
    }

}
