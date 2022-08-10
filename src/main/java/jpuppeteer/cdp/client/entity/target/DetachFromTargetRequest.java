package jpuppeteer.cdp.client.entity.target;

/**
*/
public class DetachFromTargetRequest {

    /**
    * Session to detach.
    */
    private String sessionId;

    /**
    * Deprecated.
    */
    private String targetId;

    public void setSessionId (String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public DetachFromTargetRequest(String sessionId, String targetId) {
        this.sessionId = sessionId;
        this.targetId = targetId;
    }

    public DetachFromTargetRequest() {
        this.sessionId = null;
        this.targetId = null;
    }

}