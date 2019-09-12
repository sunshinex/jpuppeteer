package jpuppeteer.httpclient;

import com.alibaba.fastjson.JSONObject;
import jpuppeteer.api.browser.BoundingBox;
import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.browser.Element;
import jpuppeteer.api.browser.Page;
import jpuppeteer.api.constant.MouseDefinition;
import jpuppeteer.api.constant.PermissionType;
import jpuppeteer.api.httpclient.SharedCookieStore;
import jpuppeteer.cdp.cdp.entity.page.DomContentEventFiredEvent;
import jpuppeteer.cdp.cdp.entity.page.WindowOpenEvent;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.chrome.ChromeBrowser;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.chrome.ChromePage;
import jpuppeteer.chrome.event.PageEvent;
import jpuppeteer.chrome.util.ArgUtils;
import jpuppeteer.chrome.util.ScriptUtils;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class HttpClient {

    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

    private static final String DEFAULT_USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";

    public static void main(String[] args) throws Exception {
        RequestConfig requestConfig = RequestConfig.custom()
                .setCircularRedirectsAllowed(false)//不允许循环重定向
                .setSocketTimeout(10000)//read timeout 10s
                .setConnectTimeout(10000)//connect timeout 10s
                .setConnectionRequestTimeout(10000)//从ConnectionManager拿connection超时10s
                .setCookieSpec(CookieSpecs.STANDARD)
                .build();
        List<BasicHeader> headers = new ArrayList<>();
        headers.add(new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
        headers.add(new BasicHeader("Accept-Encoding", "gzip, deflate, br"));
        headers.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.9"));
        headers.add(new BasicHeader("Connection", "keep-alive"));
        headers.add(new BasicHeader("Upgrade-Insecure-Requests", "1"));

        Browser browser = new ChromeLauncher(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")).launch(args);

//        Browser browser = new ChromeLauncher(new File("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")).launch(args);

        SharedCookieStore cookieStore = new SharedCookieStore(browser);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setUserAgent(DEFAULT_USERAGENT)
                .setDefaultHeaders(headers)
                .setConnectionTimeToLive(120, TimeUnit.SECONDS)//keep alive 维持2分钟
                .setDefaultRequestConfig(requestConfig)
                .setDefaultCookieStore(cookieStore)
//				.setProxy(new HttpHost("127.0.0.1", 8888))
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .build();

        //String requestUrl = "https://login.taobao.com/member/login.jhtml?useMobile=false&redirectURL=" + URLEncoder.encode("https://ovvnz.m.tmall.com/shop/shop_auction_search.do?ajson=1&_tm_source=tmallsearch&sort=s&p=9&page_size=12&from=h5&shop_id=451600818", "UTF-8");
        //HttpGet request = new HttpGet(requestUrl);
        //CloseableHttpResponse response = httpClient.execute(request);
        //String jsonStr = EntityUtils.toString(response.getEntity());
        //JSONObject jsonObject = JSON.parseObject(jsonStr);
        //String url = jsonObject.getString("url");

        Page<CallArgument> page = browser.defaultContext().newPage();
//        page.addListener(PageEvent.LOAD, event -> {
//            try {
//                Element el = page.querySelector("#subfootBaseLine");
//                logger.info("scroll start");
//                el.scrollIntoView();
//                logger.info("scroll end");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
        page.navigate("https://www.163.com/");
        page.await(PageEvent.DOMCONTENTLOADED).get();
        Future<ChromePage> future = page.await(PageEvent.OPENPAGE);
        page.querySelector(".sitemap_flink>a").click();
        ChromePage pg = future.get();
        pg.await(PageEvent.LOAD).get();
        pg.crash();
//        page.evaluateOnNewDocument(ScriptUtils.load("fake.js"));
//        page.browserContext().resetPermissions();
//        page.browserContext().grantPermissions("https://login.taobao.com", PermissionType.MIDI, PermissionType.MIDISYSEX, PermissionType.NOTIFICATIONS, PermissionType.GEOLOCATION, PermissionType.BACKGROUNDSYNC);
//        page.addListener(PageEvent.DOMCONTENTLOADED, event -> {
//            try {
//                Element username = page.waitSelector("#TPL_username_1", 10, TimeUnit.SECONDS);
//                username.clear();
//                username.input("asd17002030951");
//                page.querySelector("#TPL_password_1").input("asd123123");
//
//                Element slider = null;
//                try {
//                    slider = page.waitSelector("#nocaptcha", 1, TimeUnit.SECONDS);
//                } catch (Exception ex) {
//                    //do nth...
//                }
//                if (slider != null) {
//                    int stepWidth = 10;
//                    BoundingBox sliderBox = slider.boundingBox();
//                    while (true) {
//                        JSONObject object = page.wait(ScriptUtils.load("wait-captcha-box.js"), 2, TimeUnit.SECONDS, JSONObject.class, ArgUtils.createFromValue("#nocaptcha .nc-lang-cnt"));
//                        String status = object.getString("status");
//                        if ("READY".equals(status)) {
//                            Element box = page.waitSelector("#nc_1_n1z", 3, TimeUnit.SECONDS);
//                            BoundingBox boxBox = box.boundingBox();
//                            //鼠标移动到节点上
//                            box.hover();
//                            //按下鼠标左键
//                            page.mouseDown(MouseDefinition.LEFT);
//                            //滑动
//                            double steps = Math.ceil(sliderBox.getWidth() / stepWidth);
//                            for (int i = 0; i < steps; ) {
//                                page.mouseMove(boxBox.getX() + stepWidth * ++i, boxBox.getY() + boxBox.getHeight() / 2);
//                                //TimeUnit.MILLISECONDS.sleep(20);
//                            }
//                            page.mouseUp(MouseDefinition.LEFT);
//                            TimeUnit.MILLISECONDS.sleep(200);
//                        } else if ("OK".equals(status)) {
//                            System.out.println("成功");
//                            break;
//                        } else if ("ERROR".equals(status)) {
//                            System.out.println("失败:" + object.getString("text"));
//                            page.querySelector("#nocaptcha .nc-lang-cnt a:first-child").click();
//                        }
//                    }
//                }
//                page.querySelector("#J_SubmitStatic").click();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        page.navigate(requestUrl, requestUrl);
    }

}
