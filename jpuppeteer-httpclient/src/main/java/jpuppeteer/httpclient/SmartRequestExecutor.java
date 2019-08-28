package jpuppeteer.httpclient;

import jpuppeteer.api.browser.Browser;
import jpuppeteer.cdp.cdp.domain.IO;
import jpuppeteer.httpclient.condition.HttpRequestInfo;
import jpuppeteer.httpclient.handler.RequestMappingRegistry;
import jpuppeteer.httpclient.method.RequestHandlerMapping;
import jpuppeteer.httpclient.method.support.HandlerMethod;
import jpuppeteer.httpclient.taobao.login.TaobaoLogin;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class SmartRequestExecutor extends HttpRequestExecutor {

    private RequestHandlerMapping handlerMapping;

    private Browser browser;

    public SmartRequestExecutor(int waitForContinue, Browser browser) {
        super(waitForContinue);
        this.handlerMapping = new RequestHandlerMapping();
        this.browser = browser;
        this.handlerMapping.addMappingClass(TaobaoLogin.class);
    }

    public SmartRequestExecutor(Browser browser) {
        this(30, browser);
    }

    @Override
    public HttpResponse execute(HttpRequest request, HttpClientConnection conn, HttpContext context) throws IOException, HttpException {
        if (!(request instanceof HttpUriRequest)) {
            throw new IOException("invaild request");
        }
        HttpRequest req;
        if (request instanceof HttpRequestWrapper) {
            req = ((HttpRequestWrapper) request).getOriginal();
        } else {
            req = request;
        }
        HttpRequestInfo requestInfo = new HttpRequestInfo((HttpUriRequest) req);
        HandlerMethod handlerMethod = handlerMapping.getHandler(requestInfo);
        if (handlerMethod != null) {
            try {
                return (HttpResponse) handlerMethod.method.invoke(handlerMethod.handler, request, conn, context);
            } catch (Exception e) {
                closeConnection(conn);
                throw new HttpException("can not handle request");
            }
        } else {
            return super.execute(request, conn, context);
        }
    }

    public HttpResponse doExecute(HttpRequest request, HttpClientConnection conn, HttpContext context) throws IOException, HttpException {
        return super.execute(request, conn, context);
    }

    private static void closeConnection(final HttpClientConnection conn) {
        try {
            conn.close();
        } catch (final IOException ignore) {
        }
    }
}
