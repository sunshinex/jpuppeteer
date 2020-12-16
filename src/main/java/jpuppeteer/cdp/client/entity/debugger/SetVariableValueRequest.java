package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SetVariableValueRequest {

    /**
    * 0-based number of scope as was listed in scope chain. Only 'local', 'closure' and 'catch' scope types are allowed. Other scopes could be manipulated manually.
    */
    public final Integer scopeNumber;

    /**
    * Variable name.
    */
    public final String variableName;

    /**
    * New variable value.
    */
    public final jpuppeteer.cdp.client.entity.runtime.CallArgument newValue;

    /**
    * Id of callframe that holds variable.
    */
    public final String callFrameId;

    public SetVariableValueRequest(Integer scopeNumber, String variableName, jpuppeteer.cdp.client.entity.runtime.CallArgument newValue, String callFrameId) {
        this.scopeNumber = scopeNumber;
        this.variableName = variableName;
        this.newValue = newValue;
        this.callFrameId = callFrameId;
    }

}