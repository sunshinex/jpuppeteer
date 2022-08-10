package jpuppeteer.cdp.client.entity.page;

/**
*/
public class AddScriptToEvaluateOnLoadResponse {

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

    public AddScriptToEvaluateOnLoadResponse(String identifier) {
        this.identifier = identifier;
    }

    public AddScriptToEvaluateOnLoadResponse() {
    }

}