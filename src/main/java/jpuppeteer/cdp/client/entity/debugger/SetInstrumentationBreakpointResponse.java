package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetInstrumentationBreakpointResponse {

    /**
    * Id of the created breakpoint for further reference.
    */
    public final String breakpointId;

    public SetInstrumentationBreakpointResponse(String breakpointId) {
        this.breakpointId = breakpointId;
    }

}