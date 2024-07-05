package jpuppeteer.api;

import jpuppeteer.constant.HttpMethod;
import jpuppeteer.util.XFuture;

public interface InterceptedRequest extends InterceptedResponse {

    XFuture<?> continues(HttpMethod method, String url, HttpHeader[] headers, byte[] body);

    default XFuture<?> continues(HttpHeader[] headers) {
        return continues(null, null, headers, null);
    }

    default XFuture<?> continues(HttpHeader[] headers, byte[] body) {
        return continues(null, null, headers, body);
    }

}
