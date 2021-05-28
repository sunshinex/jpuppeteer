package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointOnFunctionCallResponse {

    /**
    * Id of the created breakpoint for further reference.
    */
    public final String breakpointId;

    public SetBreakpointOnFunctionCallResponse(String breakpointId) {
        this.breakpointId = breakpointId;
    }

}