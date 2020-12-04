package jpuppeteer.api;

import io.netty.util.concurrent.Future;

import java.util.List;

public interface InterceptedRequest extends InterceptedResponse {

    Future continues(String method, String url, HttpHeader[] headers, byte[] body);

    default Future continues(HttpHeader[] headers) {
        return continues(null, null, headers, null);
    }

    default Future continues(HttpHeader[] headers, byte[] body) {
        return continues(null, null, headers, body);
    }

}
