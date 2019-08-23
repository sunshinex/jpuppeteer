package jpuppeteer.chrome.event;

import jpuppeteer.api.event.EventType;

public abstract class AbstractEvent<E> implements EventType<E> {

    protected Class<E> eventClass;

    protected AbstractEvent(Class<E> eventClass) {
        this.eventClass = eventClass;
    }

    @Override
    public String eventName() {
        return eventClass.getName();
    }

    public Class<E> eventClass() {
        return eventClass;
    }
}
