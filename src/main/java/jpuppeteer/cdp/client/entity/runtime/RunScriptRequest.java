package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class RunScriptRequest {

    /**
    * Id of the script to run.
    */
    private String scriptId;

    /**
    * Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
    */
    private Integer executionContextId;

    /**
    * Symbolic group name that can be used to release multiple objects.
    */
    private String objectGroup;

    /**
    * In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides `setPauseOnException` state.
    */
    private Boolean silent;

    /**
    * Determines whether Command Line API should be available during the evaluation.
    */
    private Boolean includeCommandLineAPI;

    /**
    * Whether the result is expected to be a JSON object which should be sent by value.
    */
    private Boolean returnByValue;

    /**
    * Whether preview should be generated for the result.
    */
    private Boolean generatePreview;

    /**
    * Whether execution should `await` for resulting value and return once awaited promise is resolved.
    */
    private Boolean awaitPromise;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
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

    public void setSilent (Boolean silent) {
        this.silent = silent;
    }

    public Boolean getSilent() {
        return this.silent;
    }

    public void setIncludeCommandLineAPI (Boolean includeCommandLineAPI) {
        this.includeCommandLineAPI = includeCommandLineAPI;
    }

    public Boolean getIncludeCommandLineAPI() {
        return this.includeCommandLineAPI;
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

    public void setAwaitPromise (Boolean awaitPromise) {
        this.awaitPromise = awaitPromise;
    }

    public Boolean getAwaitPromise() {
        return this.awaitPromise;
    }

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

    public RunScriptRequest() {
    }

}