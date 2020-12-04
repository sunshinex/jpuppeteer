package jpuppeteer.api;

import io.netty.util.concurrent.Future;
import jpuppeteer.cdp.client.constant.network.ErrorReason;

import java.util.List;

public interface InterceptedResponse extends Request {

    String interceptorId();

    ErrorReason responseErrorReason();

    int responseStatusCode();

    HttpHeader[] responseHeaders();

    Future<byte[]> responseBody();

    Future abort();

    Future continues();

    Future respond(int statusCode, HttpHeader[] headers, byte[] body);

    default Future respond(int statusCode) {
        return respond(statusCode, null, null);
    }

}
