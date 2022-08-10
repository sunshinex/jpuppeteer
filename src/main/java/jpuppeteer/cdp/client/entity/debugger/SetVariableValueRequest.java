package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetVariableValueRequest {

    /**
    * 0-based number of scope as was listed in scope chain. Only 'local', 'closure' and 'catch' scope types are allowed. Other scopes could be manipulated manually.
    */
    private Integer scopeNumber;

    /**
    * Variable name.
    */
    private String variableName;

    /**
    * New variable value.
    */
    private jpuppeteer.cdp.client.entity.runtime.CallArgument newValue;

    /**
    * Id of callframe that holds variable.
    */
    private String callFrameId;

    public void setScopeNumber (Integer scopeNumber) {
        this.scopeNumber = scopeNumber;
    }

    public Integer getScopeNumber() {
        return this.scopeNumber;
    }

    public void setVariableName (String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return this.variableName;
    }

    public void setNewValue (jpuppeteer.cdp.client.entity.runtime.CallArgument newValue) {
        this.newValue = newValue;
    }

    public jpuppeteer.cdp.client.entity.runtime.CallArgument getNewValue() {
        return this.newValue;
    }

    public void setCallFrameId (String callFrameId) {
        this.callFrameId = callFrameId;
    }

    public String getCallFrameId() {
        return this.callFrameId;
    }

    public SetVariableValueRequest(Integer scopeNumber, String variableName, jpuppeteer.cdp.client.entity.runtime.CallArgument newValue, String callFrameId) {
        this.scopeNumber = scopeNumber;
        this.variableName = variableName;
        this.newValue = newValue;
        this.callFrameId = callFrameId;
    }

    public SetVariableValueRequest() {
    }

}