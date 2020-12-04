package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointRequest {

    /**
    * Location to set breakpoint in.
    */
    public final jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    * Expression to use as a breakpoint condition. When specified, debugger will only stop on the breakpoint if this expression evaluates to true.
    */
    public final String condition;

    public SetBreakpointRequest(jpuppeteer.cdp.client.entity.debugger.Location location, String condition) {
        this.location = location;
        this.condition = condition;
    }

    public SetBreakpointRequest(jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
        this.condition = null;
    }

}