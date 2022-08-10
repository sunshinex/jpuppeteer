package jpuppeteer.cdp.client.entity.page;

/**
*/
public class AddScriptToEvaluateOnNewDocumentResponse {

    /**
    * Identifier of the added script.
    */
    private String identifier;

    public void setIdentifier (String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public AddScriptToEvaluateOnNewDocumentResponse(String identifier) {
        this.identifier = identifier;
    }

    public AddScriptToEvaluateOnNewDocumentResponse() {
    }

}