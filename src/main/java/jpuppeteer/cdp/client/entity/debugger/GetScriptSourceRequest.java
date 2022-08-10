package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetScriptSourceRequest {

    /**
    * Id of the script to get source for.
    */
    private String scriptId;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public GetScriptSourceRequest(String scriptId) {
        this.scriptId = scriptId;
    }

    public GetScriptSourceRequest() {
    }

}