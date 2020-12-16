package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetPossibleBreakpointsRequest {

    /**
    * Start of range to search possible breakpoint locations in.
    */
    public final Location start;

    /**
    * End of range to search possible breakpoint locations in (excluding). When not specified, end of scripts is used as end of range.
    */
    public final Location end;

    /**
    * Only consider locations which are in the same (non-nested) function as start.
    */
    public final Boolean restrictToFunction;

    public GetPossibleBreakpointsRequest(Location start, Location end, Boolean restrictToFunction) {
        this.start = start;
        this.end = end;
        this.restrictToFunction = restrictToFunction;
    }

    public GetPossibleBreakpointsRequest(Location start) {
        this.start = start;
        this.end = null;
        this.restrictToFunction = null;
    }

}