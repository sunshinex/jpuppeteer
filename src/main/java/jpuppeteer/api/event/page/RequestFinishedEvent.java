package jpuppeteer.api.event.page;

import io.netty.util.concurrent.Future;
import jpuppeteer.api.Request;
import jpuppeteer.api.Response;
import jpuppeteer.api.event.PageEvent;
import jpuppeteer.cdp.client.domain.Network;
import jpuppeteer.cdp.client.entity.network.GetResponseBodyRequest;
import jpuppeteer.util.SeriesFuture;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RequestFinishedEvent extends PageEvent {

    private final Request request;

    private final Response response;

    private final String requestId;

    private final Integer encodedDataLength;

    public RequestFinishedEvent(Request request, Response response, String requestId, Integer encodedDataLength) {
        this.request = request;
        this.response = response;
        this.requestId = requestId;
        this.encodedDataLength = encodedDataLength;
    }

    public String requestId() {
        return requestId;
    }

    public Integer encodedDataLength() {
        return encodedDataLength;
    }

    public Request request() {
        return request;
    }

    public Response response() {
        return response;
    }
}
