package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointRequest {

    /**
    * Location to set breakpoint in.
    */
    private jpuppeteer.cdp.client.entity.debugger.Location location;

    /**
    * Expression to use as a breakpoint condition. When specified, debugger will only stop on the breakpoint if this expression evaluates to true.
    */
    private String condition;

    public void setLocation (jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
    }

    public jpuppeteer.cdp.client.entity.debugger.Location getLocation() {
        return this.location;
    }

    public void setCondition (String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }

    public SetBreakpointRequest(jpuppeteer.cdp.client.entity.debugger.Location location, String condition) {
        this.location = location;
        this.condition = condition;
    }

    public SetBreakpointRequest(jpuppeteer.cdp.client.entity.debugger.Location location) {
        this.location = location;
        this.condition = null;
    }

    public SetBreakpointRequest() {
    }

}