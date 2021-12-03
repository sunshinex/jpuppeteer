package jpuppeteer.api.event.page;

import jpuppeteer.api.Frame;
import jpuppeteer.constant.LifecyclePhase;

public class LifecycleEvent extends FrameEvent {

    private final LifecyclePhase phase;

    public LifecycleEvent(Frame frame, LifecyclePhase phase) {
        super(frame);
        this.phase = phase;
    }

    public LifecyclePhase phase() {
        return phase;
    }
}
