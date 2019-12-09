package jpuppeteer.chrome.event;

import jpuppeteer.cdp.cdp.entity.page.FrameAttachedEvent;
import jpuppeteer.cdp.cdp.entity.page.FrameDetachedEvent;
import jpuppeteer.cdp.cdp.entity.page.FrameNavigatedEvent;
import jpuppeteer.cdp.cdp.entity.page.LifecycleEvent;
import jpuppeteer.chrome.ChromeRequest;
import jpuppeteer.chrome.ChromeRequestFailed;
import jpuppeteer.chrome.ChromeResponse;

public class FrameEvent<E> extends AbstractEvent<E> {

    public static final FrameEvent<LifecycleEvent> LIFECYCLEEVENT = new FrameEvent<>(LifecycleEvent.class);

    public static final FrameEvent<FrameAttachedEvent> FRAMEATTACHED = new FrameEvent<>(FrameAttachedEvent.class);

    public static final FrameEvent<FrameDetachedEvent> FRAMEDETACHED = new FrameEvent<>(FrameDetachedEvent.class);

    public static final FrameEvent<FrameNavigatedEvent> FRAMENAVIGATED = new FrameEvent<>(FrameNavigatedEvent.class);

    public static final FrameEvent<ChromeRequest> REQUEST = new FrameEvent<>(ChromeRequest.class);

    public static final FrameEvent<ChromeResponse> RESPONSE = new FrameEvent<>(ChromeResponse.class);

    public static final FrameEvent<ChromeRequestFailed> REQUESTFAILED = new FrameEvent<>(ChromeRequestFailed.class);

    public static final FrameEvent<ChromeRequest> REQUESTFINISHED = new FrameEvent<>("RequestFinished", ChromeRequest.class);

    protected FrameEvent(Class<E> eventClass) {
        super(eventClass);
    }

    protected FrameEvent(String eventName, Class<E> eventClass) {
        super(eventName, eventClass);
    }

    @Override
    public String toString() {
        return "FrameEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventClass=" + eventClass +
                '}';
    }
}
