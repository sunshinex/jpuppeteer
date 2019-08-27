package jpuppeteer.httpclient;

import jpuppeteer.api.browser.Browser;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;

import java.io.IOException;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class SmartRequestExecutor extends HttpRequestExecutor {

    private Browser browser;

    public SmartRequestExecutor(int waitForContinue, Browser browser) {
        super(waitForContinue);
        this.browser = browser;
    }

    public SmartRequestExecutor(Browser browser) {
        this.browser = browser;
    }

    @Override
    public HttpResponse execute(HttpRequest request, HttpClientConnection conn, HttpContext context) throws IOException, HttpException {

        return super.execute(request, conn, context);
    }
}
