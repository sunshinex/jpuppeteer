package jpuppeteer.cdp.client.entity.page;

/**
*/
public class RemoveScriptToEvaluateOnNewDocumentRequest {

    /**
    */
    private String identifier;

    public void setIdentifier (String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public RemoveScriptToEvaluateOnNewDocumentRequest(String identifier) {
        this.identifier = identifier;
    }

    public RemoveScriptToEvaluateOnNewDocumentRequest() {
    }

}