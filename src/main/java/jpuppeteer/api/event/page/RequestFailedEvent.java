package jpuppeteer.api.event.page;

import jpuppeteer.api.Request;
import jpuppeteer.api.Response;

public class RequestFailedEvent extends PageEvent {

    private final Request request;

    private final Response response;

    private final String requestId;

    private final String error;

    private final Boolean canceled;

    public RequestFailedEvent(Request request, Response response, String requestId, String error, Boolean canceled) {
        this.request = request;
        this.response = response;
        this.requestId = requestId;
        this.error = error;
        this.canceled = canceled;
    }

    public String requestId() {
        return requestId;
    }

    public String error() {
        return error;
    }

    public Boolean canceled() {
        return canceled;
    }

    public Request request() {
        return request;
    }

    public Response response() {
        return response;
    }
}
