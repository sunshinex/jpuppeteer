package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetInstrumentationBreakpointRequest {

    /**
    * Instrumentation name.
    */
    public final jpuppeteer.cdp.client.constant.debugger.SetInstrumentationBreakpointRequestInstrumentation instrumentation;

    public SetInstrumentationBreakpointRequest(jpuppeteer.cdp.client.constant.debugger.SetInstrumentationBreakpointRequestInstrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

}