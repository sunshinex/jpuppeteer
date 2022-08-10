package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetInstrumentationBreakpointRequest {

    /**
    * Instrumentation name.
    */
    private jpuppeteer.cdp.client.constant.debugger.SetInstrumentationBreakpointRequestInstrumentation instrumentation;

    public void setInstrumentation (jpuppeteer.cdp.client.constant.debugger.SetInstrumentationBreakpointRequestInstrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    public jpuppeteer.cdp.client.constant.debugger.SetInstrumentationBreakpointRequestInstrumentation getInstrumentation() {
        return this.instrumentation;
    }

    public SetInstrumentationBreakpointRequest(jpuppeteer.cdp.client.constant.debugger.SetInstrumentationBreakpointRequestInstrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    public SetInstrumentationBreakpointRequest() {
    }

}