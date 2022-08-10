package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointOnFunctionCallResponse {

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

    public SetBreakpointOnFunctionCallResponse(String breakpointId) {
        this.breakpointId = breakpointId;
    }

    public SetBreakpointOnFunctionCallResponse() {
    }

}