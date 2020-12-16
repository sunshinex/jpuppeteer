package jpuppeteer.cdp.client.entity.target;

/**
* Issued when detached from target for any reason (including `detachFromTarget` command). Can be issued multiple times per target if multiple sessions have been attached to it.
*/
public class DetachedFromTargetEvent {

    /**
    * Detached session identifier.
    */
    public final String sessionId;

    /**
    * Deprecated.
    */
    public final String targetId;

    public DetachedFromTargetEvent(String sessionId, String targetId) {
        this.sessionId = sessionId;
        this.targetId = targetId;
    }

    public DetachedFromTargetEvent(String sessionId) {
        this.sessionId = sessionId;
        this.targetId = null;
    }

}