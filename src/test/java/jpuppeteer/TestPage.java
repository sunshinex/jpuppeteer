package jpuppeteer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.SettableFuture;
import io.netty.util.concurrent.Future;
import jpuppeteer.api.*;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.api.event.page.*;
import jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.entity.dom.BoxModel;
import jpuppeteer.cdp.client.entity.emulation.SetUserAgentOverrideRequest;
import jpuppeteer.cdp.client.entity.input.TouchPoint;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.constant.LifecyclePhase;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.util.ScriptUtil;
import jpuppeteer.util.SeriesFuture;
import org.junit.*;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
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
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger("root").setLevel(Level.INFO);
        page.addListener(new AbstractListener<DialogEvent>() {
            @Override
            public void accept(DialogEvent dialog) {
                dialog.accept();
            }
        });
        page.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36").get();
        page.navigate("https://detail.m.tmall.com/item.htm?id=633695953246");
        TimeUnit.DAYS.sleep(1);
    }

    @Test
    public void testMouseMove() throws Exception {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger("root").setLevel(Level.TRACE);
        page.setUserAgent(new SetUserAgentOverrideRequest("Mozilla/5.0 (Linux; Android 11; Redmi K30 5G Build/RQ1A.210105.003) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/87.0.4280.101 Mobile Safari/537.36", "zh-CN,en-US", "Linux armv8l", null))
                .get(5, TimeUnit.SECONDS);
        page.setDevice(ScreenOrientationType.PORTRAITPRIMARY, 393, 873, 1, true)
                .get(5, TimeUnit.SECONDS);
        page.enableTouchEmulation(true, 5)
                .get(5, TimeUnit.SECONDS);
        page.enableEmitTouchEventsForMouse(true, SetEmitTouchEventsForMouseRequestConfiguration.DESKTOP)
                .get(5, TimeUnit.SECONDS);
        page.addScriptToEvaluateOnNewDocument(ScriptUtil.load("script/fake.js"))
                .get(5, TimeUnit.SECONDS);
        page.addScriptToEvaluateOnNewDocument("const addEventListener = EventTarget.prototype.addEventListener;\n" +
                "    const injectAddEventListener = function(){\n" +
                "        let args = Array.prototype.slice.call(arguments);\n" +
                "        console.log(\"event=\", args[0]);\n" +
                "        if (args[0].indexOf('mouse') === -1) {\n" +
                "            return addEventListener.apply(this, args);\n" +
                "        }\n" +
                "        return undefined;\n" +
                "    }\n" +
                "    window.addEventListener = injectAddEventListener;\n" +
                "    EventTarget.prototype.addEventListener = injectAddEventListener;");
        page.navigate("https://h5.m.taobao.com/awp/core/detail.htm?spm=a21bo.7929913.198967.13.69784174TlpS4Z&id=534668093680")
                .get(10,TimeUnit.SECONDS);
        TimeUnit.DAYS.sleep(1);
    }

}
