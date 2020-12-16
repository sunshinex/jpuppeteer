package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class RemoveEventListenerBreakpointRequest {

    /**
    * Event name.
    */
    public final String eventName;

    /**
    * EventTarget interface name.
    */
    public final String targetName;

    public RemoveEventListenerBreakpointRequest(String eventName, String targetName) {
        this.eventName = eventName;
        this.targetName = targetName;
    }

    public RemoveEventListenerBreakpointRequest(String eventName) {
        this.eventName = eventName;
        this.targetName = null;
    }

}