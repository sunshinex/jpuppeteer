package jpuppeteer.cdp.client.entity.target;

/**
* Issued when detached from target for any reason (including `detachFromTarget` command). Can be issued multiple times per target if multiple sessions have been attached to it.
*/
public class DetachedFromTargetEvent {

    /**
    * Detached session identifier.
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

    public DetachedFromTargetEvent(String sessionId, String targetId) {
        this.sessionId = sessionId;
        this.targetId = targetId;
    }

    public DetachedFromTargetEvent(String sessionId) {
        this.sessionId = sessionId;
        this.targetId = null;
    }

    public DetachedFromTargetEvent() {
    }

}