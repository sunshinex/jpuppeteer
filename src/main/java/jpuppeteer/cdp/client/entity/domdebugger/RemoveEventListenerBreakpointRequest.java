package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class RemoveEventListenerBreakpointRequest {

    /**
    * Event name.
    */
    private String eventName;

    /**
    * EventTarget interface name.
    */
    private String targetName;

    public void setEventName (String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setTargetName (String targetName) {
        this.targetName = targetName;
    }

    public String getTargetName() {
        return this.targetName;
    }

    public RemoveEventListenerBreakpointRequest(String eventName, String targetName) {
        this.eventName = eventName;
        this.targetName = targetName;
    }

    public RemoveEventListenerBreakpointRequest(String eventName) {
        this.eventName = eventName;
        this.targetName = null;
    }

    public RemoveEventListenerBreakpointRequest() {
    }

}