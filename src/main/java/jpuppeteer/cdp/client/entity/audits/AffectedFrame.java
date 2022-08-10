package jpuppeteer.cdp.client.entity.audits;

/**
* Information about the frame affected by an inspector issue.
* experimental
*/
public class AffectedFrame {

    /**
    */
    private String frameId;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public AffectedFrame(String frameId) {
        this.frameId = frameId;
    }

    public AffectedFrame() {
    }

}