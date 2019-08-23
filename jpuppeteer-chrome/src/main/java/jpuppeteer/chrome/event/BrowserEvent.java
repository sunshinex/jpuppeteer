package jpuppeteer.chrome.event;


import jpuppeteer.cdp.cdp.entity.target.*;

public final class BrowserEvent<E> extends AbstractEvent<E> {

    public static final BrowserEvent<TargetCreatedEvent> TARGETCREATED = new BrowserEvent<>(TargetCreatedEvent.class);

    public static final BrowserEvent<TargetDestroyedEvent> TARGETDESTROYED = new BrowserEvent<>(TargetDestroyedEvent.class);

    public static final BrowserEvent<TargetCrashedEvent> TARGETCRASHED = new BrowserEvent<>(TargetCrashedEvent.class);

    public static final BrowserEvent<AttachedToTargetEvent> ATTACHEDTOTARGET = new BrowserEvent<>(AttachedToTargetEvent.class);

    public static final BrowserEvent<TargetInfoChangedEvent> TARGETINFOCHANGED = new BrowserEvent<>(TargetInfoChangedEvent.class);

    public static final BrowserEvent<DetachedFromTargetEvent> DETACHEDFROMTARGET = new BrowserEvent<>(DetachedFromTargetEvent.class);

    public static final BrowserEvent<ReceivedMessageFromTargetEvent> RECEIVEDMESSAGEFROMTARGET = new BrowserEvent<>(ReceivedMessageFromTargetEvent.class);

    private BrowserEvent(Class<E> eventClass) {
        super(eventClass);
    }

    @Override
    public String toString() {
        return "BrowserEvent{" +
                "eventClass=" + eventClass +
                '}';
    }
}
