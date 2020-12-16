package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetPossibleBreakpointsResponse {

    /**
    * List of the possible breakpoint locations.
    */
    public final java.util.List<BreakLocation> locations;

    public GetPossibleBreakpointsResponse(java.util.List<BreakLocation> locations) {
        this.locations = locations;
    }

}