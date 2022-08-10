package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointByUrlResponse {

    /**
    * Id of the created breakpoint for further reference.
    */
    private String breakpointId;

    /**
    * List of the locations this breakpoint resolved into upon addition.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.Location> locations;

    public void setBreakpointId (String breakpointId) {
        this.breakpointId = breakpointId;
    }

    public String getBreakpointId() {
        return this.breakpointId;
    }

    public void setLocations (java.util.List<jpuppeteer.cdp.client.entity.debugger.Location> locations) {
        this.locations = locations;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.Location> getLocations() {
        return this.locations;
    }

    public SetBreakpointByUrlResponse(String breakpointId, java.util.List<jpuppeteer.cdp.client.entity.debugger.Location> locations) {
        this.breakpointId = breakpointId;
        this.locations = locations;
    }

    public SetBreakpointByUrlResponse() {
    }

}