package jpuppeteer.httpclient;

import jpuppeteer.api.browser.Browser;
import jpuppeteer.chrome.ChromeLauncher;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicHeader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HttpClient {

    private static final String DEFAULT_USERAGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";

    public static void main(String... args) throws Exception {
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

        Browser browser = new ChromeLauncher(new File("D:\\workspace\\browser-driver\\bin\\chrome\\win32-x64\\chrome")).launch(args);

        CookieStore cookieStore = new SharedCookieStore(browser);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setUserAgent(DEFAULT_USERAGENT)
                .setDefaultHeaders(headers)
                .setConnectionTimeToLive(120, TimeUnit.SECONDS)//keep alive 维持2分钟
                .setDefaultRequestConfig(requestConfig)
                .setRequestExecutor(new SmartRequestExecutor(browser))
                .setDefaultCookieStore(cookieStore)
                .setRedirectStrategy(new LaxRedirectStrategy())
//				.setProxy(new HttpHost("127.0.0.1", 8888))
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .build();

        HttpGet request = new HttpGet("https://veromoda.tmall.com/");
        CloseableHttpResponse response = httpClient.execute(request);

    }
}
