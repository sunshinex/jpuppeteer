package jpuppeteer.cdp.client.entity.page;

/**
*/
public class RemoveScriptToEvaluateOnLoadRequest {

    /**
    */
    private String identifier;

    public void setIdentifier (String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public RemoveScriptToEvaluateOnLoadRequest(String identifier) {
        this.identifier = identifier;
    }

    public RemoveScriptToEvaluateOnLoadRequest() {
    }

}