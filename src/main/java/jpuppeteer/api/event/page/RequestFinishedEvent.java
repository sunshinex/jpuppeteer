package jpuppeteer.api.event.page;

import jpuppeteer.api.event.PageEvent;

public class RequestFinishedEvent extends PageEvent {

    private final String requestId;

    private final Integer encodedDataLength;

    public RequestFinishedEvent(String requestId, Integer encodedDataLength) {
        this.requestId = requestId;
        this.encodedDataLength = encodedDataLength;
    }

    public String requestId() {
        return requestId;
    }

    public Integer encodedDataLength() {
        return encodedDataLength;
    }
}
