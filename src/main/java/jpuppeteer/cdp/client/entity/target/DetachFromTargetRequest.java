package jpuppeteer.cdp.client.entity.target;

/**
*/
public class DetachFromTargetRequest {

    /**
    * Session to detach.
    */
    public final String sessionId;

    /**
    * Deprecated.
    */
    public final String targetId;

    public DetachFromTargetRequest(String sessionId, String targetId) {
        this.sessionId = sessionId;
        this.targetId = targetId;
    }

    public DetachFromTargetRequest() {
        this.sessionId = null;
        this.targetId = null;
    }

}