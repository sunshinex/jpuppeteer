package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointRequest {

    /**
    * Location to set breakpoint in.
    */
    public final Location location;

    /**
    * Expression to use as a breakpoint condition. When specified, debugger will only stop on the breakpoint if this expression evaluates to true.
    */
    public final String condition;

    public SetBreakpointRequest(Location location, String condition) {
        this.location = location;
        this.condition = condition;
    }

    public SetBreakpointRequest(Location location) {
        this.location = location;
        this.condition = null;
    }

}