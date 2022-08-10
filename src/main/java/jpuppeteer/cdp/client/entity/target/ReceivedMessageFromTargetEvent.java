package jpuppeteer.cdp.client.entity.target;

/**
* Notifies about a new protocol message received from the session (as reported in `attachedToTarget` event).
*/
public class ReceivedMessageFromTargetEvent {

    /**
    * Identifier of a session which sends a message.
    */
    private String sessionId;

    /**
    */
    private String message;

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

    public void setMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public ReceivedMessageFromTargetEvent(String sessionId, String message, String targetId) {
        this.sessionId = sessionId;
        this.message = message;
        this.targetId = targetId;
    }

    public ReceivedMessageFromTargetEvent(String sessionId, String message) {
        this.sessionId = sessionId;
        this.message = message;
        this.targetId = null;
    }

    public ReceivedMessageFromTargetEvent() {
    }

}