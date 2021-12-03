package jpuppeteer.api.event.page;

import jpuppeteer.api.Frame;

public class FrameEvent extends PageEvent {

    private final Frame frame;

    public FrameEvent(Frame frame) {
        this.frame = frame;
    }

    public Frame frame() {
        return frame;
    }
}
