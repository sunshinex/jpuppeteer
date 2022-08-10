package jpuppeteer.cdp.client.entity.debugger;

/**
* Fired when breakpoint is resolved to an actual script and location.
*/
public class BreakpointResolvedEvent {

    /**
    * Breakpoint unique identifier.
    */
    private String breakpointId;

    /**
    * Actual breakpoint location.
    */
    private jpuppeteer.cdp.client.entity.debugger.Location location;

    public void setBreakpointId (String breakpointId) {
        this.breakpointId = breakpointId;
    }

    public String getBreakpointId() {
        return this.breakpointId;
    }

    public void setLocation (jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getLocation() {
        return this.location;
    }

    public BreakpointResolvedEvent(String breakpointId, jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.breakpointId = breakpointId;
        this.location = location;
    }

    public BreakpointResolvedEvent() {
    }

}