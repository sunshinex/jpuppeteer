package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetInstrumentationBreakpointRequest {

    /**
    * Instrumentation name.
    */
    public final String instrumentation;

    public SetInstrumentationBreakpointRequest(String instrumentation) {
        this.instrumentation = instrumentation;
    }

}