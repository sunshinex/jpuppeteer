package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointOnFunctionCallRequest {

    /**
    * Function object id.
    */
    public final String objectId;

    /**
    * Expression to use as a breakpoint condition. When specified, debugger will stop on the breakpoint if this expression evaluates to true.
    */
    public final String condition;

    public SetBreakpointOnFunctionCallRequest(String objectId, String condition) {
        this.objectId = objectId;
        this.condition = condition;
    }

    public SetBreakpointOnFunctionCallRequest(String objectId) {
        this.objectId = objectId;
        this.condition = null;
    }

}