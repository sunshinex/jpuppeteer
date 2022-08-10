package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class CompileScriptRequest {

    /**
    * Expression to compile.
    */
    private String expression;

    /**
    * Source url to be set for the script.
    */
    private String sourceURL;

    /**
    * Specifies whether the compiled script should be persisted.
    */
    private Boolean persistScript;

    /**
    * Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
    */
    private Integer executionContextId;

    public void setExpression (String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return this.expression;
    }

    public void setSourceURL (String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getSourceURL() {
        return this.sourceURL;
    }

    public void setPersistScript (Boolean persistScript) {
        this.persistScript = persistScript;
    }

    public Boolean getPersistScript() {
        return this.persistScript;
    }

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

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

    public CompileScriptRequest() {
    }

}