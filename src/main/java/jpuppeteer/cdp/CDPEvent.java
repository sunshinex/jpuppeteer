package jpuppeteer.cdp;

import jpuppeteer.cdp.client.CDPEventType;


public class CDPEvent {

    public final String sessionId;

    public final CDPEventType method;

    private final Object params;

    public CDPEvent(String sessionId, CDPEventType method, Object params) {
        this.sessionId = sessionId;
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
                "sessionId='" + sessionId + '\'' +
                ", method=" + method +
                ", params=" + params +
                '}';
    }
}
