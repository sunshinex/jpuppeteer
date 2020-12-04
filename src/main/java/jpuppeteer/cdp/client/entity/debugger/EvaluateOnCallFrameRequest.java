package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class EvaluateOnCallFrameRequest {

    /**
    * Call frame identifier to evaluate on.
    */
    public final String callFrameId;

    /**
    * Expression to evaluate.
    */
    public final String expression;

    /**
    * String object group name to put result into (allows rapid releasing resulting object handles using `releaseObjectGroup`).
    */
    public final String objectGroup;

    /**
    * Specifies whether command line API should be available to the evaluated expression, defaults to false.
    */
    public final Boolean includeCommandLineAPI;

    /**
    * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides `setPauseOnException` state.
    */
    public final Boolean silent;

    /**
    * Whether the result is expected to be a JSON object that should be sent by value.
    */
    public final Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    public final Boolean generatePreview;

    /**
    * Whether to throw an exception if side effect cannot be ruled out during evaluation.
    */
    public final Boolean throwOnSideEffect;

    /**
    * Terminate execution after timing out (number of milliseconds).
    */
    public final java.math.BigDecimal timeout;

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

}