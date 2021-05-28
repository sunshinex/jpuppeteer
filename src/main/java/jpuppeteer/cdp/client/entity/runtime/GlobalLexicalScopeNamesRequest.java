package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class GlobalLexicalScopeNamesRequest {

    /**
    * Specifies in which execution context to lookup global scope variables.
    */
    public final Integer executionContextId;

    public GlobalLexicalScopeNamesRequest(Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public GlobalLexicalScopeNamesRequest() {
        this.executionContextId = null;
    }

}