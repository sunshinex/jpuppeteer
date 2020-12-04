package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CompileScriptRequest {

    /**
    * Expression to compile.
    */
    public final String expression;

    /**
    * Source url to be set for the script.
    */
    public final String sourceURL;

    /**
    * Specifies whether the compiled script should be persisted.
    */
    public final Boolean persistScript;

    /**
    * Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
    */
    public final Integer executionContextId;

    public CompileScriptRequest(String expression, String sourceURL, Boolean persistScript, Integer executionContextId) {
        this.expression = expression;
        this.sourceURL = sourceURL;
        this.persistScript = persistScript;
        this.executionContextId = executionContextId;
    }

    public CompileScriptRequest(String expression, String sourceURL, Boolean persistScript) {
        this.expression = expression;
        this.sourceURL = sourceURL;
        this.persistScript = persistScript;
        this.executionContextId = null;
    }

}