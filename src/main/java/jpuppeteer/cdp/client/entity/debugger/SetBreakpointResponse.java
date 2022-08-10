package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointResponse {

    /**
    * Id of the created breakpoint for further reference.
    */
    private String breakpointId;

    /**
    * Location this breakpoint resolved into.
    */
    private jpuppeteer.cdp.client.entity.debugger.Location actualLocation;

    public void setBreakpointId (String breakpointId) {
        this.breakpointId = breakpointId;
    }

    public String getBreakpointId() {
        return this.breakpointId;
    }

    public void setActualLocation (jpuppeteer.cdp.client.entity.debugger.Location actualLocation) {
        this.actualLocation = actualLocation;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getActualLocation() {
        return this.actualLocation;
    }

    public SetBreakpointResponse(String breakpointId, jpuppeteer.cdp.client.entity.debugger.Location actualLocation) {
        this.breakpointId = breakpointId;
        this.actualLocation = actualLocation;
    }

    public SetBreakpointResponse() {
    }

}