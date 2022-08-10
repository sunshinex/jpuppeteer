package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetInstrumentationBreakpointRequest {

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

    public SetInstrumentationBreakpointRequest(String eventName) {
        this.eventName = eventName;
    }

    public SetInstrumentationBreakpointRequest() {
    }

}