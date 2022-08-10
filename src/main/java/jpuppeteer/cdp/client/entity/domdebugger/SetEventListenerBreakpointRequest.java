package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetEventListenerBreakpointRequest {

    /**
    * DOM Event name to stop on (any DOM event will do).
    */
    private String eventName;

    /**
    * EventTarget interface name to stop on. If equal to `"*"` or not provided, will stop on any EventTarget.
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

    public SetEventListenerBreakpointRequest(String eventName, String targetName) {
        this.eventName = eventName;
        this.targetName = targetName;
    }

    public SetEventListenerBreakpointRequest(String eventName) {
        this.eventName = eventName;
        this.targetName = null;
    }

    public SetEventListenerBreakpointRequest() {
    }

}