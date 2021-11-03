package jpuppeteer.cdp;

import jpuppeteer.cdp.client.CDPEventType;


public class CDPEvent {

    public final CDPEventType method;

    private final Object params;

    public CDPEvent(CDPEventType method, Object params) {
        this.method = method;
        this.params = params;
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject() {
        return (T) params;
    }

    @Override
    public String toString() {
        return "CDPEvent{" +
                "method=" + method +
                ", params=" + params +
                '}';
    }
}
