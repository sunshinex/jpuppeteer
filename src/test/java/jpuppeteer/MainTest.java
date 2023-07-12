package jpuppeteer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.common.collect.Lists;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GlobalEventExecutor;
import jpuppeteer.api.*;
import jpuppeteer.api.event.AbstractListener;
import jpuppeteer.api.event.page.LoadedEvent;
import jpuppeteer.api.event.page.PageEvent;
import jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType;
import jpuppeteer.cdp.client.constant.emulation.SetEmitTouchEventsForMouseRequestConfiguration;
import jpuppeteer.cdp.client.constant.fetch.RequestStage;
import jpuppeteer.cdp.client.entity.dom.BoxModel;
import jpuppeteer.cdp.client.entity.domsnapshot.NameValue;
import jpuppeteer.cdp.client.entity.emulation.*;
import jpuppeteer.cdp.client.entity.fetch.EnableRequest;
import jpuppeteer.cdp.client.entity.fetch.RequestPattern;
import jpuppeteer.cdp.client.entity.network.CookieParam;
import jpuppeteer.chrome.ChromeBrowser;
import jpuppeteer.chrome.ChromeElement;
import jpuppeteer.chrome.ChromeFrame;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.constant.WatchAction;
import jpuppeteer.entity.BasicHttpHeader;
import jpuppeteer.util.JacksonUtil;
import jpuppeteer.util.ScriptUtil;
import jpuppeteer.util.XFuture;
import jpuppeteer.util.XPromise;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import sun.net.www.http.HttpClient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class MainTest {

    private volatile String token;

    private String execute(HttpUriRequest request) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createMinimal(new BasicHttpClientConnectionManager())) {
            CloseableHttpResponse response = httpClient.execute(request);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() != 200) {
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
            }
            if (response.getEntity() == null) {
                return null;
            }
            return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        }
    }

    private void login() throws IOException {
        HttpPost request = new HttpPost("http://tiancaiapi.tablecando.cn/api/Member/login");
        HttpEntity entity = EntityBuilder.create()
                .setParameters(
                        new BasicNameValuePair("member_user", "cianiubi"),
                        new BasicNameValuePair("member_pwd", "2459f808f5467438a1d3cf23b33f9257")
                )
                .setContentType(ContentType.create("application/x-www-form-urlencoded", "utf-8"))
                .build();
        request.setEntity(entity);
        String ret = execute(request);
        JsonNode retJson = JacksonUtil.INSTANCE.readTree(ret);
        this.token = retJson.get("token").asText();
    }

    public String wxH5Login(String url) throws IOException {
        if (StringUtils.isEmpty(this.token)) {
            login();
        }
        HttpPost request = new HttpPost("http://tiancaiapi.tablecando.cn/api/Order/CreateOrder");
        request.addHeader("Authorization", this.token);
        HttpEntity entity = MultipartEntityBuilder.create()
                .addTextBody("type", "0")
                .addTextBody("url", url)
                .addTextBody("projectid", "5386")
                .setCharset(StandardCharsets.UTF_8)
                .build();
        request.setEntity(entity);
        String ret = execute(request);
        JsonNode retJson = JacksonUtil.INSTANCE.readTree(ret);
        JsonNode data = retJson.get("data");
        return data.get("fullurl").asText();
    }

    @Test
    public void test() throws Exception {
        String fakeJs = ScriptUtil.load("script/fake_h5.js");
//        ExecutorService executors = Executors.newFixedThreadPool(10);
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger("root").setLevel(Level.INFO);

        Browser browser = new ChromeLauncher("D:\\chrome87\\chrome.exe").launch("--user-data-dir=D:\\tmp\\chrome\\pdd\\2", "--proxy-server=127.0.0.1:8888");
        BrowserContext context = browser.createContext().get(10, TimeUnit.SECONDS);
        Page page = context.newPage().get(10, TimeUnit.SECONDS);
        SetUserAgentOverrideRequest userAgent = new SetUserAgentOverrideRequest();
        userAgent.setUserAgent("Mozilla/5.0 (Linux; Android 12; REDMI K30 5G Build/RQ3A.211001.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3262 MMWEBSDK/20220204 Mobile Safari/537.36 MMWEBID/3729 MicroMessenger/8.0.20.2100(0x28001438) Process/toolsmp WeChat/arm32 Weixin NetType/4G Language/zh_CN ABI/arm64");
        userAgent.setPlatform("Linux armv8l");
        userAgent.setAcceptLanguage("zh-CN,zh");
        page.setUserAgent(userAgent).get(10, TimeUnit.SECONDS);
        SetDeviceMetricsOverrideRequest device = new SetDeviceMetricsOverrideRequest();
        device.setScreenOrientation(new ScreenOrientation(ScreenOrientationType.PORTRAITPRIMARY, 0));
        device.setMobile(true);
        device.setDeviceScaleFactor(new BigDecimal("2.75"));
        device.setScreenHeight(393);
        device.setScreenHeight(673);
        device.setWidth(393);
        device.setHeight(673);

        page.setDevice(device).get(10, TimeUnit.SECONDS);
        page.enableTouchEmulation(true, 5).get(10, TimeUnit.SECONDS);
        page.enableEmitTouchEventsForMouse(true, SetEmitTouchEventsForMouseRequestConfiguration.MOBILE).get(10, TimeUnit.SECONDS);
        //将微信登录的请求拦截下来, 处理自动登录
//        page.enableNetwork().get(10, TimeUnit.SECONDS);
//        page.setHeaders(
//                new BasicHttpHeader("sec-fetch-mode", "cors"),
//                new BasicHttpHeader("x-requested-with", "com.tencent.mm")
//        ).get(10, TimeUnit.SECONDS);
        page.addScriptToEvaluateOnNewDocument("window.fakeRandom = " + Math.random())
                .get(5, TimeUnit.SECONDS);
        page.addScriptToEvaluateOnNewDocument(fakeJs).get(10, TimeUnit.SECONDS);
//        String userId = UUID.randomUUID().toString().replace("-", "");
//        String password = DigestUtils.md5Hex(userId + "|ASJNLUYTRFVKIUTFFVJJJKKJKKJJYFCCFXT");
//        page.enableAuthentication(authenticator -> {
//            authenticator.accept(userId, password);
//        }).get(10, TimeUnit.SECONDS);
        String cookies = "pdd_user_id=4399731337906; PDDAccessToken=FOCX2P7LLLFQRQSOSRCCDGTUIE5NTZ5BKHDXCMANL45PGHIT7TPA112b209; pdd_user_uin=354YB2T5MJ65RVGCBGJIEWORZA_GEXDA; api_uid=CknWMmRE2iwdUwB0SZlPAg; _nano_fp=XpEJX5PqXqCblpT8n9_wyHT1rCIjHHHh9ygo1YzG; webp=1; jrpl=Fd4lI6pdYx3ltUkqyacfynxK5nMvyA7i; njrpl=Fd4lI6pdYx3ltUkqyacfynxK5nMvyA7i; dilx=3oVrdaM0PteeNl7JZzKo4; pdd_vds=gaRMAZKvWZHfXvHXVCKZgzzCXMXCzqzvzrXzXfAWjYkhkqgrpDKMWzFvkXJq";
        List<NameValuePair> cookieList = URLEncodedUtils.parse(cookies, StandardCharsets.UTF_8, ';');
        CookieParam[] cookieParams = cookieList.stream()
                .map(c -> {
                    String name = StringUtils.trim(c.getName());
                    if (StringUtils.isEmpty(name)) {
                        return null;
                    }
                    CookieParam cp = new CookieParam(name, c.getValue());
                    cp.setDomain(".mobile.yangkeduo.com");
                    cp.setPath("/");
                    cp.setSecure(true);
                    return cp;
                })
                .filter(Objects::nonNull)
                .toArray(CookieParam[]::new);
        context.setCookies(cookieParams).get(10, TimeUnit.SECONDS);
//        RequestPattern pattern = new RequestPattern("*", null, RequestStage.REQUEST);
//        page.enableRequestInterception(
//                new EnableRequest(Lists.newArrayList(pattern), true),
//                new Interceptor<InterceptedResponse>() {
//                    @Override
//                    public void intercept(InterceptedResponse request) {
//                        String url = request.url();
//                        if (url.startsWith("https://open.weixin.qq.com/connect/oauth2/authorize?")) {
//                            executors.submit(() -> {
//                                try {
//                                    int pos = request.url().indexOf('#');
//                                    String baseUrl = pos != -1 ? request.url().substring(0, pos) : request.url();
//                                    String location = wxH5Login(baseUrl);
//                                    HttpHeader[] headers = new HttpHeader[] {
//                                            new BasicHttpHeader("Location", location),
//                                            new BasicHttpHeader("Referer", baseUrl)
//                                    };
//                                    request.respond(302, headers, null).get(10, TimeUnit.SECONDS);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                    try {
//                                        request.continues().get(10, TimeUnit.SECONDS);
//                                    } catch (Exception e1) {
//                                        e1.printStackTrace();
//                                    }
//                                }
//                            });
//                        } else {
//                            request.continues();
//                        }
//                    }
//
//                    @Override
//                    public void authenticate(Authenticator authenticator) {
//                        authenticator.accept(userId, password);
//                    }
//                }
//        );
        page.addListener(new AbstractListener<LoadedEvent>() {
            @Override
            public void accept(LoadedEvent pageEvent) {
                System.out.println("loaded");
            }
        });
        //page.navigate("https://yangkeduo.com/goods.html?goods_id=265041174851").get(30, TimeUnit.SECONDS);
        TimeUnit.DAYS.sleep(1);
    }

    @Test
    public void test3() throws Exception {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.getLogger("root").setLevel(Level.DEBUG);

        Browser browser = new ChromeLauncher("D:\\chrome87\\chrome.exe").launch(new String[]{"--proxy-server=127.0.0.1:8888"});
        Page page = browser.newPage().get(10, TimeUnit.SECONDS);
        page.addListener(new AbstractListener<LoadedEvent>() {
            @Override
            public void accept(LoadedEvent event) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            Element body = page.querySelector("body").get(10, TimeUnit.SECONDS);
                            String html = body.getProperty("innerHTML", String.class).get(10, TimeUnit.SECONDS);
                            System.out.println(html);
                        } catch (Exception e) {

                        }
                    }
                }.start();
            }
        });
        page.navigate("https://www.baidu.com/");
        TimeUnit.DAYS.sleep(1);
    }

}
