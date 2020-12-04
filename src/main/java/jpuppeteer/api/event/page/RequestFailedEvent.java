package jpuppeteer.api.event.page;

import jpuppeteer.api.event.PageEvent;

public class RequestFailedEvent extends PageEvent {

    private final String requestId;

    private final String error;

    private final Boolean canceled;

    public RequestFailedEvent(String requestId, String error, Boolean canceled) {
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
}
