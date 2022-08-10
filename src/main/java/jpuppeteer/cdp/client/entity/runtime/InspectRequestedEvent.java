package jpuppeteer.cdp.client.entity.runtime;

/**
* Issued when object should be inspected (for example, as a result of inspect() command line API call).
*/
public class InspectRequestedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject object;

    /**
    */
    private java.util.Map<String, Object> hints;

    public void setObject (jpuppeteer.cdp.client.entity.runtime.RemoteObject object) {
        this.object = object;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getObject() {
        return this.object;
    }

    public void setHints (java.util.Map<String, Object> hints) {
        this.hints = hints;
    }

    public java.util.Map<String, Object> getHints() {
        return this.hints;
    }

    public InspectRequestedEvent(jpuppeteer.cdp.client.entity.runtime.RemoteObject object, java.util.Map<String, Object> hints) {
        this.object = object;
        this.hints = hints;
    }

    public InspectRequestedEvent() {
    }

}