package jpuppeteer.httpclient.interceptor.taobao.login;

import jpuppeteer.api.browser.Browser;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

public class TaobaoLogin implements HttpRequestInterceptor {

    private Browser browser;

    public TaobaoLogin(Browser browser) {
        this.browser = browser;
    }

    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        System.out.println(request);
    }
}
