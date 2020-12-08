package jpuppeteer.api.event.page;

import jpuppeteer.api.Request;
import jpuppeteer.api.Response;
import jpuppeteer.api.event.PageEvent;

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
