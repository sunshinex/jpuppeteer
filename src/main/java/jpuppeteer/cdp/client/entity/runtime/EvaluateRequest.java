package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class EvaluateRequest {

    /**
    * Expression to evaluate.
    */
    public final String expression;

    /**
    * Symbolic group name that can be used to release multiple objects.
    */
    public final String objectGroup;

    /**
    * Determines whether Command Line API should be available during the evaluation.
    */
    public final Boolean includeCommandLineAPI;

    /**
    * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides `setPauseOnException` state.
    */
    public final Boolean silent;

    /**
    * Specifies in which execution context to perform evaluation. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
    */
    public final Integer contextId;

    /**
    * Whether the result is expected to be a JSON object that should be sent by value.
    */
    public final Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    public final Boolean generatePreview;

    /**
    * Whether execution should be treated as initiated by user in the UI.
    */
    public final Boolean userGesture;

    /**
    * Whether execution should `await` for resulting value and return once awaited promise is resolved.
    */
    public final Boolean awaitPromise;

    /**
    * Whether to throw an exception if side effect cannot be ruled out during evaluation. This implies `disableBreaks` below.
    */
    public final Boolean throwOnSideEffect;

    /**
    * Terminate execution after timing out (number of milliseconds).
    */
    public final java.math.BigDecimal timeout;

    /**
    * Disable breakpoints during execution.
    */
    public final Boolean disableBreaks;

    /**
    * Reserved flag for future REPL mode support. Setting this flag has currently no effect.
    */
    public final Boolean replMode;

    public EvaluateRequest(String expression, String objectGroup, Boolean includeCommandLineAPI, Boolean silent, Integer contextId, Boolean returnByValue, Boolean generatePreview, Boolean userGesture, Boolean awaitPromise, Boolean throwOnSideEffect, java.math.BigDecimal timeout, Boolean disableBreaks, Boolean replMode) {
        this.expression = expression;
        this.objectGroup = objectGroup;
        this.includeCommandLineAPI = includeCommandLineAPI;
        this.silent = silent;
        this.contextId = contextId;
        this.returnByValue = returnByValue;
        this.generatePreview = generatePreview;
        this.userGesture = userGesture;
        this.awaitPromise = awaitPromise;
        this.throwOnSideEffect = throwOnSideEffect;
        this.timeout = timeout;
        this.disableBreaks = disableBreaks;
        this.replMode = replMode;
    }

    public EvaluateRequest(String expression) {
        this.expression = expression;
        this.objectGroup = null;
        this.includeCommandLineAPI = null;
        this.silent = null;
        this.contextId = null;
        this.returnByValue = null;
        this.generatePreview = null;
        this.userGesture = null;
        this.awaitPromise = null;
        this.throwOnSideEffect = null;
        this.timeout = null;
        this.disableBreaks = null;
        this.replMode = null;
    }

}