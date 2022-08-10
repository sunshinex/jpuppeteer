package jpuppeteer.cdp.client.entity.page;

/**
*/
public class ScreencastFrameAckRequest {

    /**
    * Frame number.
    */
    private Integer sessionId;

    public void setSessionId (Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getSessionId() {
        return this.sessionId;
    }

    public ScreencastFrameAckRequest(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public ScreencastFrameAckRequest() {
    }

}