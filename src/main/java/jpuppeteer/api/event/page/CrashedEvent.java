package jpuppeteer.api.event.page;

import jpuppeteer.api.event.PageEvent;

public class CrashedEvent extends PageEvent {

    private final int errorCode;

    private final String status;

    public CrashedEvent(int errorCode, String status) {
        this.errorCode = errorCode;
        this.status = status;
    }

    public String status() {
        return status;
    }

    public int errorCode() {
        return errorCode;
    }
}
