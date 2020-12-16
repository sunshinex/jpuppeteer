package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointByUrlResponse {

    /**
    * Id of the created breakpoint for further reference.
    */
    public final String breakpointId;

    /**
    * List of the locations this breakpoint resolved into upon addition.
    */
    public final java.util.List<Location> locations;

    public SetBreakpointByUrlResponse(String breakpointId, java.util.List<Location> locations) {
        this.breakpointId = breakpointId;
        this.locations = locations;
    }

}