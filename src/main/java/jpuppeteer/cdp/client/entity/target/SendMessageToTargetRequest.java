package jpuppeteer.cdp.client.entity.target;

/**
*/
public class SendMessageToTargetRequest {

    /**
    */
    public final String message;

    /**
    * Identifier of the session.
    */
    public final String sessionId;

    /**
    * Deprecated.
    */
    public final String targetId;

    public SendMessageToTargetRequest(String message, String sessionId, String targetId) {
        this.message = message;
        this.sessionId = sessionId;
        this.targetId = targetId;
    }

    public SendMessageToTargetRequest(String message) {
        this.message = message;
        this.sessionId = null;
        this.targetId = null;
    }

}