package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetEventListenerBreakpointRequest {

    /**
    * DOM Event name to stop on (any DOM event will do).
    */
    public final String eventName;

    /**
    * EventTarget interface name to stop on. If equal to `"*"` or not provided, will stop on any EventTarget.
    */
    public final String targetName;

    public SetEventListenerBreakpointRequest(String eventName, String targetName) {
        this.eventName = eventName;
        this.targetName = targetName;
    }

    public SetEventListenerBreakpointRequest(String eventName) {
        this.eventName = eventName;
        this.targetName = null;
    }

}