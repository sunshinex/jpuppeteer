package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class RunScriptRequest {

    /**
    * Id of the script to run.
    */
    public final String scriptId;

    /**
    * Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
    */
    public final Integer executionContextId;

    /**
    * Symbolic group name that can be used to release multiple objects.
    */
    public final String objectGroup;

    /**
    * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides `setPauseOnException` state.
    */
    public final Boolean silent;

    /**
    * Determines whether Command Line API should be available during the evaluation.
    */
    public final Boolean includeCommandLineAPI;

    /**
    * Whether the result is expected to be a JSON object which should be sent by value.
    */
    public final Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    public final Boolean generatePreview;

    /**
    * Whether execution should `await` for resulting value and return once awaited promise is resolved.
    */
    public final Boolean awaitPromise;

    public RunScriptRequest(String scriptId, Integer executionContextId, String objectGroup, Boolean silent, Boolean includeCommandLineAPI, Boolean returnByValue, Boolean generatePreview, Boolean awaitPromise) {
        this.scriptId = scriptId;
        this.executionContextId = executionContextId;
        this.objectGroup = objectGroup;
        this.silent = silent;
        this.includeCommandLineAPI = includeCommandLineAPI;
        this.returnByValue = returnByValue;
        this.generatePreview = generatePreview;
        this.awaitPromise = awaitPromise;
    }

    public RunScriptRequest(String scriptId) {
        this.scriptId = scriptId;
        this.executionContextId = null;
        this.objectGroup = null;
        this.silent = null;
        this.includeCommandLineAPI = null;
        this.returnByValue = null;
        this.generatePreview = null;
        this.awaitPromise = null;
    }

}