package jpuppeteer.cdp.client.entity.target;

/**
*/
public class AttachToTargetResponse {

    /**
    * Id assigned to the session.
    */
    public final String sessionId;

    public AttachToTargetResponse(String sessionId) {
        this.sessionId = sessionId;
    }

}