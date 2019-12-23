package jpuppeteer.cdp;

import jpuppeteer.api.event.EventType;
import jpuppeteer.cdp.cdp.CDPEventType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CDPEventWrapper implements EventType<CDPEvent> {

    private static volatile Map<CDPEventType, CDPEventWrapper> wrapperMap = new ConcurrentHashMap<>();

    private CDPEventType eventType;

    private CDPEventWrapper(CDPEventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String eventName() {
        return eventType.getValue();
    }

    @Override
    public Class<CDPEvent> eventClass() {
        return CDPEvent.class;
    }

    public static synchronized CDPEventWrapper wrap(CDPEventType eventType) {
        CDPEventWrapper wrapper;
        if (!wrapperMap.containsKey(eventType)) {
            wrapper = new CDPEventWrapper(eventType);
            wrapperMap.putIfAbsent(eventType, wrapper);
        } else {
            wrapper = wrapperMap.get(eventType);
        }
        return wrapper;
    }
}
