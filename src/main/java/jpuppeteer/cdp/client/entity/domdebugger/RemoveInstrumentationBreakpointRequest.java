package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class RemoveInstrumentationBreakpointRequest {

    /**
    * Instrumentation name to stop on.
    */
    private String eventName;

    public void setEventName (String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public RemoveInstrumentationBreakpointRequest(String eventName) {
        this.eventName = eventName;
    }

    public RemoveInstrumentationBreakpointRequest() {
    }

}