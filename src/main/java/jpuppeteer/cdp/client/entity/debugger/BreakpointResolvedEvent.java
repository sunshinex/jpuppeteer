package jpuppeteer.cdp.client.entity.debugger;

/**
* Fired when breakpoint is resolved to an actual script and location.
*/
public class BreakpointResolvedEvent {

    /**
    * Breakpoint unique identifier.
    */
    public final String breakpointId;

    /**
    * Actual breakpoint location.
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location location;

    public BreakpointResolvedEvent(String breakpointId, jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.breakpointId = breakpointId;
        this.location = location;
    }

}