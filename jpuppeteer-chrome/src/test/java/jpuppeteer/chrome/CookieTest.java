package jpuppeteer.chrome;

import com.google.common.collect.Lists;
import jpuppeteer.api.browser.*;
import jpuppeteer.api.httpclient.SharedCookieStore;
import jpuppeteer.cdp.cdp.entity.page.DomContentEventFiredEvent;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.chrome.event.FrameEvent;
import jpuppeteer.chrome.event.PageEvent;
import jpuppeteer.chrome.util.ArgUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.junit.Assert;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CookieTest {

    private static final String DEFAULT_USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";

    private static final String[] ARGS = new String[]{
            "--headless"
    };

    @Test
    public void test() throws Exception {
        String url = "https://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=yy0aYDVrCpbxOLCYBQlFA0XG&redirect_uri=http://127.0.0.1:8080/token&scope=basic,netdisk&display=tv&qrcode=1";
        Browser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        Page<CallArgument> page = browser.defaultContext().newPage();
        page.navigate(url);
        Element qrcode = page.waitSelector(".tang-pass-qrcode-img", 10, TimeUnit.SECONDS);
        String src = page.evaluate("function(qrcode){return qrcode.src;}", String.class, ArgUtils.createFromObject((ChromeBrowserObject) qrcode));
        System.out.println(src);
    }

    @Test
    public void testSetCookie() throws Exception {
        Browser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch(ARGS);
        browser.setCookie(Cookie.builder().domain(".baidu.com").name("test123").value("test456").path("/").build());
        Page<CallArgument> page = browser.defaultContext().newPage();
        page.setUserAgent(new UserAgent(DEFAULT_USERAGENT));
        Future<DomContentEventFiredEvent> future = page.await(PageEvent.DOMCONTENTLOADED);
        page.navigate("https://www.baidu.com/");
        DomContentEventFiredEvent event = future.get();
        Integer offset = page.evaluate("function(){return document.cookie.indexOf('test123');}", Integer.class);
        Assert.assertNotEquals(-1L, (long) offset);
    }

    @Test
    public void testShareCookie() throws Exception {
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

        Browser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch(ARGS);

        SharedCookieStore cookieStore = new SharedCookieStore(browser);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setUserAgent(DEFAULT_USERAGENT)
                .setDefaultHeaders(headers)
                .setConnectionTimeToLive(120, TimeUnit.SECONDS)//keep alive 维持2分钟
                .setDefaultRequestConfig(requestConfig)
                .setDefaultCookieStore(cookieStore)
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .build();

        HttpGet request = new HttpGet("https://www.baidu.com");
        CloseableHttpResponse response = httpClient.execute(request);
        HttpClientUtils.closeQuietly(response);

        List<Cookie> cookies = browser.cookies();
        System.out.println(cookies);
        Assert.assertFalse(CollectionUtils.isEmpty(cookies));
    }

    @Test
    public void test2() throws Exception {
        Browser browser = new ChromeLauncher(Constant.CHROME_EXECUTABLE_PATH).launch();
        ChromePage page = browser.defaultContext().newPage();
        //page.enableRequestInterception(true);
        //page.authenticate("test", "test");
        page.enableRequestInterception();
        page.addListener(FrameEvent.REQUEST, request -> {
            try {
                if (request.url().getPath().equals("/")) {
//                    request.continues(ChromeRequest.builder()
//                            .headers(Lists.newArrayList(new Header("User-Agent", "Android")))
//                            .build());
//                    FileInputStream is = new FileInputStream("D:\\bd_logo1.png");
                    String body = "<script type='text/javascript'>alert(prompt('123', '456'));</script>";
                    List<Header> headers = new ArrayList<>();
                    headers.add(new Header("Content-Type", "text/html; charset=utf-8"));
                    request.respond(200, headers, body.getBytes());
                } else {
                    request.continues();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        page.addListener(PageEvent.DIALOG, event -> {
            try {
                event.accept("test");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        page.navigate("http://10.199.215.216/");
        TimeUnit.HOURS.sleep(1);
    }
}
