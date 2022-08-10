package jpuppeteer.cdp.client.entity.page;

/**
*/
public class AddScriptToEvaluateOnLoadRequest {

    /**
    */
    private String scriptSource;

    public void setScriptSource (String scriptSource) {
        this.scriptSource = scriptSource;
    }

    public String getScriptSource() {
        return this.scriptSource;
    }

    public AddScriptToEvaluateOnLoadRequest(String scriptSource) {
        this.scriptSource = scriptSource;
    }

    public AddScriptToEvaluateOnLoadRequest() {
    }

}