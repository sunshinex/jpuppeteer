package jpuppeteer;

import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.Page;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.api.event.page.RequestEvent;
import jpuppeteer.api.event.page.RequestFailedEvent;
import jpuppeteer.api.event.page.RequestFinishedEvent;
import jpuppeteer.api.event.page.ResponseEvent;
import jpuppeteer.cdp.client.constant.network.ResourceType;
import jpuppeteer.chrome.ChromeLauncher;
import org.junit.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestPage {

    private static Browser browser;

    @BeforeClass
    public static void setUpClass() throws Exception {
        browser = new ChromeLauncher(TestConfig.CHROME).launch(TestConfig.CHROME_ARGS);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        browser.close().get();
    }

    private BrowserContext context;

    private Page page;

    @Before
    public void setUp() throws Exception {
        context = browser.createContext().get();
        page = context.newPage().get();
    }

    @After
    public void tearDown() throws Exception {
        try {
            page.close().get();
        } finally {
            context.close().get();
        }
    }

    @Test
    public void browserContext() {
        Assert.assertEquals(context, page.browserContext());
    }

    @Test
    public void bringToFront() throws ExecutionException, InterruptedException {
        page.bringToFront().get();
    }

    @Test
    public void addScriptToEvaluateOnNewDocument() throws ExecutionException, InterruptedException {
        String id = page.addScriptToEvaluateOnNewDocument("console.log('test')").get();
        Assert.assertNotNull(id);
    }

    @Test
    public void removeScriptToEvaluateOnNewDocument() throws ExecutionException, InterruptedException {
        String id = page.addScriptToEvaluateOnNewDocument("console.log('test')").get();
        Assert.assertNotNull(id);
        page.removeScriptToEvaluateOnNewDocument(id).get();
    }

    @Test
    public void enableCache() throws ExecutionException, InterruptedException {
        page.enableCache().get();
    }

    @Test
    public void disableCache() throws ExecutionException, InterruptedException {
        page.disableCache().get();
    }

    @Test
    public void addBinding() throws ExecutionException, InterruptedException {
        page.addBinding("xxxxx", (isolate, payload) -> {
            System.out.println(payload);
        }).get();
    }

    @Test
    public void removeBinding() throws ExecutionException, InterruptedException {
        page.addBinding("xxxxx", (isolate, payload) -> {
            System.out.println(payload);
        }).get();
        page.removeBinding("xxxxx").get();
    }

    @Test
    public void navigate() throws ExecutionException, InterruptedException {
        page.addListener(new AbstractListener<RequestFinishedEvent>() {
            @Override
            public void accept(RequestFinishedEvent event) {
                System.out.println(event);
            }
        });
        try {
            page.navigate("http://www.baidu.com/").get();
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            TimeUnit.SECONDS.sleep(5);
        }
    }

}
