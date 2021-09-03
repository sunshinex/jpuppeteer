package jpuppeteer.cdp.client.entity.audits;

/**
* Information about the frame affected by an inspector issue.
* experimental
*/
public class AffectedFrame {

    /**
    */
    public final String frameId;

    public AffectedFrame(String frameId) {
        this.frameId = frameId;
    }

}