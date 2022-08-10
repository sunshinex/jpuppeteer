package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class EvaluateOnCallFrameRequest {

    /**
    * Call frame identifier to evaluate on.
    */
    private String callFrameId;

    /**
    * Expression to evaluate.
    */
    private String expression;

    /**
    * String object group name to put result into (allows rapid releasing resulting object handles using `releaseObjectGroup`).
    */
    private String objectGroup;

    /**
    * Specifies whether command line API should be available to the evaluated expression, defaults to false.
    */
    private Boolean includeCommandLineAPI;

    /**
    * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides `setPauseOnException` state.
    */
    private Boolean silent;

    /**
    * Whether the result is expected to be a JSON object that should be sent by value.
    */
    private Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    private Boolean generatePreview;

    /**
    * Whether to throw an exception if side effect cannot be ruled out during evaluation.
    */
    private Boolean throwOnSideEffect;

    /**
    * Terminate execution after timing out (number of milliseconds).
    */
    private java.math.BigDecimal timeout;

    public void setCallFrameId (String callFrameId) {
        this.callFrameId = callFrameId;
    }

    public String getCallFrameId() {
        return this.callFrameId;
    }

    public void setExpression (String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return this.expression;
    }

    public void setObjectGroup (String objectGroup) {
        this.objectGroup = objectGroup;
    }

    public String getObjectGroup() {
        return this.objectGroup;
    }

    public void setIncludeCommandLineAPI (Boolean includeCommandLineAPI) {
        this.includeCommandLineAPI = includeCommandLineAPI;
    }

    public Boolean getIncludeCommandLineAPI() {
        return this.includeCommandLineAPI;
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

    public void setThrowOnSideEffect (Boolean throwOnSideEffect) {
        this.throwOnSideEffect = throwOnSideEffect;
    }

    public Boolean getThrowOnSideEffect() {
        return this.throwOnSideEffect;
    }

    public void setTimeout (java.math.BigDecimal timeout) {
        this.timeout = timeout;
    }

    public java.math.BigDecimal getTimeout() {
        return this.timeout;
    }

    public EvaluateOnCallFrameRequest(String callFrameId, String expression, String objectGroup, Boolean includeCommandLineAPI, Boolean silent, Boolean returnByValue, Boolean generatePreview, Boolean throwOnSideEffect, java.math.BigDecimal timeout) {
        this.callFrameId = callFrameId;
        this.expression = expression;
        this.objectGroup = objectGroup;
        this.includeCommandLineAPI = includeCommandLineAPI;
        this.silent = silent;
        this.returnByValue = returnByValue;
        this.generatePreview = generatePreview;
        this.throwOnSideEffect = throwOnSideEffect;
        this.timeout = timeout;
    }

    public EvaluateOnCallFrameRequest(String callFrameId, String expression) {
        this.callFrameId = callFrameId;
        this.expression = expression;
        this.objectGroup = null;
        this.includeCommandLineAPI = null;
        this.silent = null;
        this.returnByValue = null;
        this.generatePreview = null;
        this.throwOnSideEffect = null;
        this.timeout = null;
    }

    public EvaluateOnCallFrameRequest() {
    }

}