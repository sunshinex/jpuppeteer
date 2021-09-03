package jpuppeteer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.SettableFuture;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.concurrent.*;
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
import org.apache.commons.lang3.StringUtils;
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
        browser.close();
    }

    private BrowserContext context;

    private Page page;

    @Before
    public void setUp() throws Exception {
//        context = browser.createContext().get();
//        page = context.newPage().get();
    }

    @After
    public void tearDown() throws Exception {
//        try {
//            page.close().get();
//        } finally {
//            context.close().get();
//        }
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
        page.addScriptToEvaluateOnNewDocument(ScriptUtil.load("script/fake.js"))
                .get(5, TimeUnit.SECONDS);
        page.addListener(new AbstractListener<LoadedEvent>() {
            @Override
            public void accept(LoadedEvent event) {
                page.browserContext().getCookies().addListener(f -> {
                    System.out.println(f.getNow());
                });
            }
        });
        page.navigate("http://epub.cnipa.gov.cn/")
                .get(10,TimeUnit.SECONDS);
        TimeUnit.DAYS.sleep(1);
    }

    @Test
    public void testx1() {
        int[] range = new int[]{78, 101};
        for(int i=0; i<12; i++) {
            System.out.println("echo " + Integer.toHexString(1 << i) + " | sudo tee /proc/irq/" + (range[0]) + "/smp_affinity");
            range[0]++;
            System.out.println("echo " + Integer.toHexString(1 << i) + " | sudo tee /proc/irq/" + (range[1]) + "/smp_affinity");
            range[1]--;
        }
        range = new int[]{104, 127};
        for(int i=12; i<24; i++) {
            System.out.println("echo " + Integer.toHexString(1 << i) + " | sudo tee /proc/irq/" + (range[0]) + "/smp_affinity");
            range[0]++;
            System.out.println("echo " + Integer.toHexString(1 << i) + " | sudo tee /proc/irq/" + (range[1]) + "/smp_affinity");
            range[1]--;
        }
    }

    @Test
    public void testxxx() throws Exception {
        String shopListStr = "https://yichenghuayi.world.tmall.com\n" +
                "https://qianrengangoutlets.tmall.com\n" +
                "https://list.tmall.com\n" +
                "https://www.tmall.com\n" +
                "https://gmftz.tmall.com\n" +
                "https://freetexglobal.tmall.hk\n" +
                "https://yahjjry.tmall.com\n" +
                "https://dianshiguo.world.tmall.com\n" +
                "https://gecai.tmall.com\n" +
                "https://huanglongxuan.tmall.com\n" +
                "https://luoganzhen.tmall.com\n" +
                "https://ouyu.tmall.com\n" +
                "https://shengchendq.tmall.com\n" +
                "https://tongxiaochu.tmall.com\n" +
                "https://tuofu.tmall.com\n" +
                "https://xiangcang.tmall.com\n" +
                "https://zhide.tmall.com\n" +
                "https://carin.tmall.hk\n" +
                "https://minghaozb.tmall.com\n" +
                "https://jingnuo.tmall.com\n" +
                "https://jinjiafu.tmall.com\n" +
                "https://huangjinjiasp.tmall.com\n" +
                "https://kach.tmall.com\n" +
                "https://hanfenna.tmall.com\n" +
                "https://christopherobin.tmall.hk\n" +
                "https://cinemasecrets.tmall.hk\n" +
                "https://malingoetz.tmall.hk\n" +
                "https://drunkelephant.tmall.hk\n" +
                "https://100pure.tmall.hk\n" +
                "https://fragrancenet.tmall.hk\n" +
                "https://charlottetilbury.tmall.hk\n" +
                "https://lagirl.tmall.hk\n" +
                "https://feelunique.tmall.hk\n" +
                "https://mariobadescu.tmall.hk\n" +
                "https://penhaligons.tmall.hk\n" +
                "https://rosebud.tmall.hk\n" +
                "https://boots.tmall.hk\n" +
                "https://thebodyshop.tmall.hk\n" +
                "https://anastasiabeverlyhillsglobal.tmall.hk\n" +
                "https://apivita.tmall.hk\n" +
                "https://dermafirm.tmall.hk\n" +
                "https://ruiladiyafusi.tmall.com\n" +
                "https://hudabeauty.tmall.hk\n" +
                "https://livingproof.tmall.hk\n" +
                "https://panpuriofficial.tmall.hk\n" +
                "https://roundlab.tmall.hk\n" +
                "https://revisionskincare.tmall.hk\n" +
                "https://sepai.tmall.hk\n" +
                "https://imunny.tmall.hk\n" +
                "https://babyglobal.tmall.hk\n" +
                "https://luoliluo.tmall.com\n" +
                "https://shenlaobo.tmall.com\n" +
                "https://dashengtulou.tmall.com\n" +
                "https://damohong.tmall.com\n" +
                "https://zhangxiaoma.tmall.com\n" +
                "https://changjiping.tmall.com\n" +
                "https://sangshutang.tmall.com\n" +
                "https://oryxs.tmall.com\n" +
                "https://pages.tmall.com\n" +
                "https://farminapetfoods.tmall.hk\n" +
                "https://yichiwj.tmall.com\n" +
                "https://zhanji.tmall.com\n" +
                "https://nutriciamuying.tmall.hk\n" +
                "https://yikouxiang.tmall.com\n" +
                "https://jlyjx.tmall.com\n" +
                "https://boyakejl.tmall.com\n" +
                "https://topsglobal.tmall.hk\n" +
                "https://probio7.tmall.hk\n" +
                "https://superdiet.tmall.hk\n" +
                "https://jarrow.tmall.hk\n" +
                "https://lambertz.tmall.hk\n" +
                "https://lifenutrition.tmall.hk\n" +
                "https://risal.tmall.hk\n" +
                "https://folotto.tmall.hk\n" +
                "https://drvitamins.tmall.hk\n" +
                "https://irvinsglobal.tmall.hk\n" +
                "https://astaxin.tmall.hk\n" +
                "https://biomenta.tmall.hk\n" +
                "https://naturescare.tmall.hk\n" +
                "https://emart.tmall.hk\n" +
                "https://huebner.tmall.hk\n" +
                "https://oceanfit.tmall.hk\n" +
                "https://hkgangpinyijia.tmall.hk\n" +
                "https://drdunnerbjsp.tmall.hk\n" +
                "https://estheprolabo.tmall.hk\n" +
                "https://vitamore-au.tmall.hk\n" +
                "https://vogels.tmall.hk\n" +
                "https://vitasedds.tmall.hk\n";


        String[] shopList = shopListStr.split("\n");
        StringBuilder sb = new StringBuilder();
        for(String shop : shopList) {
            shop = StringUtils.trim(shop);
            if (StringUtils.isEmpty(shop)) {
                continue;
            }
            String shopUrl = shop.replace(".tmall.com", ".m.tmall.com")
                    .replace(".tmall.hk", ".m.tmall.com");
            Promise promise = GlobalEventExecutor.INSTANCE.newPromise();
            AbstractListener<LoadedEvent> listener = new AbstractListener<LoadedEvent>() {
                @Override
                public void accept(LoadedEvent event) {
                    page.url().addListener(f -> {
                        if (f.cause() != null) {
                            promise.tryFailure(new Exception("failed"));
                            return;
                        }
                        String url = (String) f.getNow();
                        if (url.contains("err.tmall.com")) {
                            promise.tryFailure(new Exception("noshop"));
                            return;
                        }
                        if (!url.contains(".m.tmall.com")) {
                            promise.tryFailure(new Exception(url));
                            return;
                        }
                        page.eval("window.__vmGlobalData__", 1000, JSONObject.class)
                                .addListener(f1 -> {
                                    if (f1.cause() != null) {
                                        promise.tryFailure(new Exception("failed"));
                                        return;
                                    }
                                    promise.trySuccess(f1.getNow());
                                });
                    });
                }
            };
            page.addListener(listener);
            page.navigate(shopUrl);
            try {
                JSONObject object = (JSONObject) promise.get();
                sb.append(shop)
                        .append("\t")
                        .append(object.getString("shopId"))
                        .append("\t")
                        .append(object.getString("sellerId"))
                        .append("\t")
                        .append("success");
            } catch (Exception cause) {
                sb.append(shop)
                        .append("\t")
                        .append("0")
                        .append("\t")
                        .append("0")
                        .append("\t")
                        .append(cause.getMessage());
            } finally {
                page.removeListener(listener);
            }
            sb.append("\r\n");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testx2() throws Exception {
        BrowserContext ctx = browser.createContext("127.0.0.1:8889").get();
        Page page = ctx.newPage().get();
        page.navigate("http://www.163.com/").get();
        TimeUnit.DAYS.sleep(1);
    }

}
