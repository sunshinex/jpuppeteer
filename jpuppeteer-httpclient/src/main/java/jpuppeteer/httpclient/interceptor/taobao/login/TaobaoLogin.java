package jpuppeteer.httpclient.interceptor.taobao.login;

import jpuppeteer.api.browser.Browser;
import jpuppeteer.api.browser.Page;
import jpuppeteer.api.browser.UserAgent;
import jpuppeteer.cdp.cdp.entity.runtime.CallArgument;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.*;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaobaoLogin implements HttpRequestInterceptor {

    private static final String[] SHARED_HEADERS = new String[]{
            HttpHeaders.ACCEPT,
            HttpHeaders.ACCEPT_ENCODING,
            HttpHeaders.ACCEPT_LANGUAGE,
            HttpHeaders.USER_AGENT
    };

    private Browser browser;

    public TaobaoLogin(Browser browser) {
        this.browser = browser;
    }

    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        try {
            HttpRequestWrapper requestWrapper;
            if (request instanceof HttpRequestWrapper) {
                requestWrapper = (HttpRequestWrapper) request;
            } else {
                requestWrapper = HttpRequestWrapper.wrap(request);
            }
            HttpClientContext clientContext = HttpClientContext.adapt(context);

            //共享header
            Page<CallArgument> page = browser.defaultContext().newPage();
            jpuppeteer.api.browser.Header[] headers = new jpuppeteer.api.browser.Header[SHARED_HEADERS.length];
            int index = 0;
            for(String headerName : SHARED_HEADERS) {
                Header header = requestWrapper.getFirstHeader(headerName);
                if (header != null) {
                    headers[index++] = new jpuppeteer.api.browser.Header(header.getName(), header.getValue());
                }
            }
            if (index > 0) {
                jpuppeteer.api.browser.Header[] sharedHeaders = new jpuppeteer.api.browser.Header[index];
                System.arraycopy(headers, 0, sharedHeaders, 0, index);
                page.setExtraHTTPHeaders(headers);
            }
            Header referer = requestWrapper.getFirstHeader(HttpHeaders.REFERER);
            page.navigate(requestWrapper.getTarget().toURI() + requestWrapper.getURI().toString(), referer != null ? referer.getValue() : null);
        } catch (Exception e) {
            throw new HttpException("open browser page failed", e);
        }
        System.out.println(request);
    }
}
