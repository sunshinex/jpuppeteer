package jpuppeteer.chrome.event;

import jpuppeteer.api.event.EventType;

public abstract class AbstractEvent<E> implements EventType<E> {

    protected String eventName;

    protected Class<E> eventClass;

    protected AbstractEvent(String eventName, Class<E> eventClass) {
        this.eventName = eventName;
        this.eventClass = eventClass;
    }

    protected AbstractEvent(Class<E> eventClass) {
        this(eventClass.getName(), eventClass);
    }

    @Override
    public String eventName() {
        return eventName;
    }

    public Class<E> eventClass() {
        return eventClass;
    }
}
