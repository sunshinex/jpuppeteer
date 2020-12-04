package jpuppeteer.api.event.page;

import jpuppeteer.api.event.PageEvent;

public class CrashedEvent extends PageEvent {

    private final String status;

    private final int errorCode;

    public CrashedEvent(String status, int errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    public String status() {
        return status;
    }

    public int errorCode() {
        return errorCode;
    }
}
