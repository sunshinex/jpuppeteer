package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetInstrumentationBreakpointRequest {

    /**
    * Instrumentation name to stop on.
    */
    public final String eventName;

    public SetInstrumentationBreakpointRequest(String eventName) {
        this.eventName = eventName;
    }

}