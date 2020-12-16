package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetScriptSourceRequest {

    /**
    * Id of the script to get source for.
    */
    public final String scriptId;

    public GetScriptSourceRequest(String scriptId) {
        this.scriptId = scriptId;
    }

}