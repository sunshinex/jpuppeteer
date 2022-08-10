package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetPossibleBreakpointsResponse {

    /**
    * List of the possible breakpoint locations.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.BreakLocation> locations;

    public void setLocations (java.util.List<jpuppeteer.cdp.client.entity.debugger.BreakLocation> locations) {
        this.locations = locations;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.BreakLocation> getLocations() {
        return this.locations;
    }

    public GetPossibleBreakpointsResponse(java.util.List<jpuppeteer.cdp.client.entity.debugger.BreakLocation> locations) {
        this.locations = locations;
    }

    public GetPossibleBreakpointsResponse() {
    }

}