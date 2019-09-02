package jpuppeteer.chrome.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jpuppeteer.api.browser.BoundingBox;
import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.browser.Element;
import jpuppeteer.api.browser.Page;
import jpuppeteer.api.httpclient.SharedCookieStore;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import jpuppeteer.chrome.ChromeBrowser;
import jpuppeteer.chrome.ChromeLauncher;
import jpuppeteer.chrome.ChromePage;
import jpuppeteer.chrome.event.PageEvent;
import jpuppeteer.chrome.util.ScriptUtils;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HttpClient {

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

        ChromeBrowser browser = new ChromeLauncher(new File("D:\\workspace\\browser-driver\\bin\\chrome\\win32-x64\\chrome")).launch(args);

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

        String requestUrl = "https://login.taobao.com/member/login.jhtml?useMobile=false&redirectURL=" + URLEncoder.encode("https://ovvnz.m.tmall.com/shop/shop_auction_search.do?ajson=1&_tm_source=tmallsearch&sort=s&p=9&page_size=12&from=h5&shop_id=451600818", "UTF-8");
        //HttpGet request = new HttpGet(requestUrl);
        //CloseableHttpResponse response = httpClient.execute(request);
        //String jsonStr = EntityUtils.toString(response.getEntity());
        //JSONObject jsonObject = JSON.parseObject(jsonStr);
        //String url = jsonObject.getString("url");

        Page<CallArgument> page = browser.defaultContext().newPage();
        page.evaluateOnNewDocument(ScriptUtils.load("fake.js"));
        page.addListener(PageEvent.DOMCONTENTLOADED, event -> {
            try {
                Element username = page.waitSelector("#TPL_username_1", 10, TimeUnit.SECONDS);
                username.clear();
                username.input("17002030951");
                page.querySelector("#TPL_password_1").input("vip123456");
                Element element = page.waitSelector("#nocaptcha", 3, TimeUnit.SECONDS);
                BoundingBox boundingBox = element.boundingBox();
                double sliderWidth = boundingBox.getWidth();
                System.out.println(sliderWidth);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        page.navigate(requestUrl, requestUrl);
    }

}
