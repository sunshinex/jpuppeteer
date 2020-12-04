package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class RestartFrameRequest {

    /**
    * Call frame identifier to evaluate on.
    */
    public final String callFrameId;

    public RestartFrameRequest(String callFrameId) {
        this.callFrameId = callFrameId;
    }

}