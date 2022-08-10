package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetBreakpointOnFunctionCallRequest {

    /**
    * Function object id.
    */
    private String objectId;

    /**
    * Expression to use as a breakpoint condition. When specified, debugger will stop on the breakpoint if this expression evaluates to true.
    */
    private String condition;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setCondition (String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }

    public SetBreakpointOnFunctionCallRequest(String objectId, String condition) {
        this.objectId = objectId;
        this.condition = condition;
    }

    public SetBreakpointOnFunctionCallRequest(String objectId) {
        this.objectId = objectId;
        this.condition = null;
    }

    public SetBreakpointOnFunctionCallRequest() {
    }

}