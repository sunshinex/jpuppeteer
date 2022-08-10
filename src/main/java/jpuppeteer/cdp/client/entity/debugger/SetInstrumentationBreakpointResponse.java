package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetInstrumentationBreakpointResponse {

    /**
    * Id of the created breakpoint for further reference.
    */
    private String breakpointId;

    public void setBreakpointId (String breakpointId) {
        this.breakpointId = breakpointId;
    }

    public String getBreakpointId() {
        return this.breakpointId;
    }

    public SetInstrumentationBreakpointResponse(String breakpointId) {
        this.breakpointId = breakpointId;
    }

    public SetInstrumentationBreakpointResponse() {
    }

}