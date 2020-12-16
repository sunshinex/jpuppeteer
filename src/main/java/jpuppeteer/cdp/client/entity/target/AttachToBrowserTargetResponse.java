package jpuppeteer.cdp.client.entity.target;

/**
*/
public class AttachToBrowserTargetResponse {

    /**
    * Id assigned to the session.
    */
    public final String sessionId;

    public AttachToBrowserTargetResponse(String sessionId) {
        this.sessionId = sessionId;
    }

}