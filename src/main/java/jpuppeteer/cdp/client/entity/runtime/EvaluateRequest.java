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
    * Specifies in which execution context to perform evaluation. If the parameter is omitted the evaluation will be performed in the context of the inspected page. This is mutually exclusive with `uniqueContextId`, which offers an alternative way to identify the execution context that is more reliable in a multi-process environment.
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
    * Setting this flag to true enables `let` re-declaration and top-level `await`. Note that `let` variables can only be re-declared if they originate from `replMode` themselves.
    */
    public final Boolean replMode;

    /**
    * The Content Security Policy (CSP) for the target might block 'unsafe-eval' which includes eval(), Function(), setTimeout() and setInterval() when called with non-callable arguments. This flag bypasses CSP for this evaluation and allows unsafe-eval. Defaults to true.
    */
    public final Boolean allowUnsafeEvalBlockedByCSP;

    /**
    * An alternative way to specify the execution context to evaluate in. Compared to contextId that may be reused accross processes, this is guaranteed to be system-unique, so it can be used to prevent accidental evaluation of the expression in context different than intended (e.g. as a result of navigation accross process boundaries). This is mutually exclusive with `contextId`.
    */
    public final String uniqueContextId;

    public EvaluateRequest(String expression, String objectGroup, Boolean includeCommandLineAPI, Boolean silent, Integer contextId, Boolean returnByValue, Boolean generatePreview, Boolean userGesture, Boolean awaitPromise, Boolean throwOnSideEffect, java.math.BigDecimal timeout, Boolean disableBreaks, Boolean replMode, Boolean allowUnsafeEvalBlockedByCSP, String uniqueContextId) {
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
        this.allowUnsafeEvalBlockedByCSP = allowUnsafeEvalBlockedByCSP;
        this.uniqueContextId = uniqueContextId;
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
        this.allowUnsafeEvalBlockedByCSP = null;
        this.uniqueContextId = null;
    }

}