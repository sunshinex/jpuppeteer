package jpuppeteer;

import com.google.common.util.concurrent.SettableFuture;
import jpuppeteer.api.Browser;
import jpuppeteer.api.BrowserContext;
import jpuppeteer.api.Element;
import jpuppeteer.api.Page;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.api.event.page.DomReadyEvent;
import jpuppeteer.api.event.page.LoadedEvent;
import jpuppeteer.api.event.page.RequestFinishedEvent;
import jpuppeteer.cdp.client.entity.dom.BoxModel;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.util.ScriptUtil;
import jpuppeteer.util.SeriesFuture;
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
        page.navigate("about:blank").get();
    }

    @Test
    public void waitSelector() throws ExecutionException, InterruptedException {
        SettableFuture<Element> future = SettableFuture.create();
        page.addListener(new AbstractListener<DomReadyEvent>() {
            @Override
            public void accept(DomReadyEvent event) {
                page.waitSelector("#pc_0_0 > li:nth-child(1) > div.txt-box > h3 > a", 10, TimeUnit.SECONDS)
                        .addListener(f -> {
                            future.set((Element) f.getNow());
                        });
            }
        });
        page.navigate("https://weixin.sogou.com/");
        Element element = future.get();
        BoxModel boxModel = element.boxModel().get();
        System.out.println(boxModel);
    }

    @Test
    public void fake() throws ExecutionException, InterruptedException {
        page.addScriptToEvaluateOnNewDocument(ScriptUtil.load("script/fake.js"));
        page.navigate("https://detail.m.tmall.com/item.htm?id=633695953246");
        TimeUnit.DAYS.sleep(1);
    }

}
