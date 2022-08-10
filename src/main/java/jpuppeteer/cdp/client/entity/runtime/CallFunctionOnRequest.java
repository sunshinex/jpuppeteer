package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CallFunctionOnRequest {

    /**
    * Declaration of the function to call.
    */
    private String functionDeclaration;

    /**
    * Identifier of the object to call function on. Either objectId or executionContextId should be specified.
    */
    private String objectId;

    /**
    * Call arguments. All call arguments must belong to the same JavaScript world as the target object.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.runtime.CallArgument> arguments;

    /**
    * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides `setPauseOnException` state.
    */
    private Boolean silent;

    /**
    * Whether the result is expected to be a JSON object which should be sent by value.
    */
    private Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    private Boolean generatePreview;

    /**
    * Whether execution should be treated as initiated by user in the UI.
    */
    private Boolean userGesture;

    /**
    * Whether execution should `await` for resulting value and return once awaited promise is resolved.
    */
    private Boolean awaitPromise;

    /**
    * Specifies execution context which global object will be used to call function on. Either executionContextId or objectId should be specified.
    */
    private Integer executionContextId;

    /**
    * Symbolic group name that can be used to release multiple objects. If objectGroup is not specified and objectId is, objectGroup will be inherited from object.
    */
    private String objectGroup;

    public void setFunctionDeclaration (String functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
    }

    public String getFunctionDeclaration() {
        return this.functionDeclaration;
    }

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setArguments (java.util.List<jpuppeteer.cdp.client.entity.runtime.CallArgument> arguments) {
        this.arguments = arguments;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.runtime.CallArgument> getArguments() {
        return this.arguments;
    }

    public void setSilent (Boolean silent) {
        this.silent = silent;
    }

    public Boolean getSilent() {
        return this.silent;
    }

    public void setReturnByValue (Boolean returnByValue) {
        this.returnByValue = returnByValue;
    }

    public Boolean getReturnByValue() {
        return this.returnByValue;
    }

    public void setGeneratePreview (Boolean generatePreview) {
        this.generatePreview = generatePreview;
    }

    public Boolean getGeneratePreview() {
        return this.generatePreview;
    }

    public void setUserGesture (Boolean userGesture) {
        this.userGesture = userGesture;
    }

    public Boolean getUserGesture() {
        return this.userGesture;
    }

    public void setAwaitPromise (Boolean awaitPromise) {
        this.awaitPromise = awaitPromise;
    }

    public Boolean getAwaitPromise() {
        return this.awaitPromise;
    }

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public void setObjectGroup (String objectGroup) {
        this.objectGroup = objectGroup;
    }

    public String getObjectGroup() {
        return this.objectGroup;
    }

    public CallFunctionOnRequest(String functionDeclaration, String objectId, java.util.List<jpuppeteer.cdp.client.entity.runtime.CallArgument> arguments, Boolean silent, Boolean returnByValue, Boolean generatePreview, Boolean userGesture, Boolean awaitPromise, Integer executionContextId, String objectGroup) {
        this.functionDeclaration = functionDeclaration;
        this.objectId = objectId;
        this.arguments = arguments;
        this.silent = silent;
        this.returnByValue = returnByValue;
        this.generatePreview = generatePreview;
        this.userGesture = userGesture;
        this.awaitPromise = awaitPromise;
        this.executionContextId = executionContextId;
        this.objectGroup = objectGroup;
    }

    public CallFunctionOnRequest(String functionDeclaration) {
        this.functionDeclaration = functionDeclaration;
        this.objectId = null;
        this.arguments = null;
        this.silent = null;
        this.returnByValue = null;
        this.generatePreview = null;
        this.userGesture = null;
        this.awaitPromise = null;
        this.executionContextId = null;
        this.objectGroup = null;
    }

    public CallFunctionOnRequest() {
    }

}