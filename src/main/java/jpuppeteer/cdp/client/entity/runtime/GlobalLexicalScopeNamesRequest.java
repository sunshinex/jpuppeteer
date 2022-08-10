package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GlobalLexicalScopeNamesRequest {

    /**
    * Specifies in which execution context to lookup global scope variables.
    */
    private Integer executionContextId;

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

    public GlobalLexicalScopeNamesRequest(Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public GlobalLexicalScopeNamesRequest() {
        this.executionContextId = null;
    }

}