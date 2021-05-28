package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class RemoveInstrumentationBreakpointRequest {

    /**
    * Instrumentation name to stop on.
    */
    public final String eventName;

    public RemoveInstrumentationBreakpointRequest(String eventName) {
        this.eventName = eventName;
    }

}