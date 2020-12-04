package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetPossibleBreakpointsResponse {

    /**
    * List of the possible breakpoint locations.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.debugger.BreakLocation> locations;

    public GetPossibleBreakpointsResponse(java.util.List<jpuppeteer.cdp.client.entity.debugger.BreakLocation> locations) {
        this.locations = locations;
    }

}