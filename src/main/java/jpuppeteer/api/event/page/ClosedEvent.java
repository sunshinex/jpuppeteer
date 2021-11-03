package jpuppeteer.api.event.page;

import jpuppeteer.api.Frame;
import jpuppeteer.api.event.FrameEvent;

public class ClosedEvent extends FrameEvent {

    public ClosedEvent(Frame frame) {
        super(frame);
    }
}
