package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetPossibleBreakpointsRequest {

    /**
    * Start of range to search possible breakpoint locations in.
    */
    private jpuppeteer.cdp.client.entity.debugger.Location start;

    /**
    * End of range to search possible breakpoint locations in (excluding). When not specified, end of scripts is used as end of range.
    */
    private jpuppeteer.cdp.client.entity.debugger.Location end;

    /**
    * Only consider locations which are in the same (non-nested) function as start.
    */
    private Boolean restrictToFunction;

    public void setStart (jpuppeteer.cdp.client.entity.debugger.Location start) {
        this.start = start;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getStart() {
        return this.start;
    }

    public void setEnd (jpuppeteer.cdp.client.entity.debugger.Location end) {
        this.end = end;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getEnd() {
        return this.end;
    }

    public void setRestrictToFunction (Boolean restrictToFunction) {
        this.restrictToFunction = restrictToFunction;
    }

    public Boolean getRestrictToFunction() {
        return this.restrictToFunction;
    }

    public GetPossibleBreakpointsRequest(jpuppeteer.cdp.client.entity.debugger.Location start, jpuppeteer.cdp.client.entity.debugger.Location end, Boolean restrictToFunction) {
        this.start = start;
        this.end = end;
        this.restrictToFunction = restrictToFunction;
    }

    public GetPossibleBreakpointsRequest(jpuppeteer.cdp.client.entity.debugger.Location start) {
        this.start = start;
        this.end = null;
        this.restrictToFunction = null;
    }

    public GetPossibleBreakpointsRequest() {
    }

}