package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointResponse {

    /**
    * Id of the created breakpoint for further reference.
    */
    public final String breakpointId;

    /**
    * Location this breakpoint resolved into.
    */
    public final Location actualLocation;

    public SetBreakpointResponse(String breakpointId, Location actualLocation) {
        this.breakpointId = breakpointId;
        this.actualLocation = actualLocation;
    }

}