package jpuppeteer.cdp.client.entity.target;

/**
*/
public class SendMessageToTargetRequest {

    /**
    */
    private String message;

    /**
    * Identifier of the session.
    */
    private String sessionId;

    /**
    * Deprecated.
    */
    private String targetId;

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

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

    public SendMessageToTargetRequest() {
    }

}