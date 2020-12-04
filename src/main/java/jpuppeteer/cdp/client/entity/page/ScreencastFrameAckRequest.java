package jpuppeteer.cdp.client.entity.page;

/**
*/
public class ScreencastFrameAckRequest {

    /**
    * Frame number.
    */
    public final Integer sessionId;

    public ScreencastFrameAckRequest(Integer sessionId) {
        this.sessionId = sessionId;
    }

}