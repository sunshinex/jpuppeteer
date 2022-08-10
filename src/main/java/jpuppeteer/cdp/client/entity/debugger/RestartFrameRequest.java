package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class RestartFrameRequest {

    /**
    * Call frame identifier to evaluate on.
    */
    private String callFrameId;

    public void setCallFrameId (String callFrameId) {
        this.callFrameId = callFrameId;
    }

    public String getCallFrameId() {
        return this.callFrameId;
    }

    public RestartFrameRequest(String callFrameId) {
        this.callFrameId = callFrameId;
    }

    public RestartFrameRequest() {
    }

}