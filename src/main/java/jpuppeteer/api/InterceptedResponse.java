package jpuppeteer.api;

import jpuppeteer.cdp.client.constant.network.ErrorReason;
import jpuppeteer.util.XFuture;

public interface InterceptedResponse extends Request {

    String interceptorId();

    ErrorReason responseErrorReason();

    int responseStatusCode();

    HttpHeader[] responseHeaders();

    XFuture<byte[]> responseBody();

    XFuture<?> abort();

    XFuture<?> continues();

    XFuture<?> respond(int statusCode, String responsePhrase, HttpHeader[] headers, byte[] body);

    default XFuture<?> respond(int statusCode, String responsePhrase) {
        return respond(statusCode, responsePhrase, null, null);
    }

    default XFuture<?> respond(int statusCode) {
        return respond(statusCode, null, null, null);
    }

}
