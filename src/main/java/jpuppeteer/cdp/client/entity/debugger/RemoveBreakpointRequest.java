package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class RemoveBreakpointRequest {

    /**
    */
    private String breakpointId;

    public void setBreakpointId (String breakpointId) {
        this.breakpointId = breakpointId;
    }

    public String getBreakpointId() {
        return this.breakpointId;
    }

    public RemoveBreakpointRequest(String breakpointId) {
        this.breakpointId = breakpointId;
    }

    public RemoveBreakpointRequest() {
    }

}