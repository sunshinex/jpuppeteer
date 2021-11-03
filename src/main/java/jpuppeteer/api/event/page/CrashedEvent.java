package jpuppeteer.api.event.page;

import jpuppeteer.api.Frame;
import jpuppeteer.api.event.FrameEvent;

public class CrashedEvent extends FrameEvent {

    private final int errorCode;

    private final String status;

    public CrashedEvent(Frame frame, int errorCode, String status) {
        super(frame);
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
