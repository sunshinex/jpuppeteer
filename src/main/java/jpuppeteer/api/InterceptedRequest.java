package jpuppeteer.api;

import jpuppeteer.util.XFuture;

public interface InterceptedRequest extends InterceptedResponse {

    XFuture<?> continues(String method, String url, HttpHeader[] headers, byte[] body);

    default XFuture<?> continues(HttpHeader[] headers) {
        return continues(null, null, headers, null);
    }

    default XFuture<?> continues(HttpHeader[] headers, byte[] body) {
        return continues(null, null, headers, body);
    }

}
