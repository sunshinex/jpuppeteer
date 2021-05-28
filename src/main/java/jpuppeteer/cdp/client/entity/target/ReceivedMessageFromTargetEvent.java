package jpuppeteer.cdp.client.entity.target;

/**
* Notifies about a new protocol message received from the session (as reported in `attachedToTarget` event).
*/
public class ReceivedMessageFromTargetEvent {

    /**
    * Identifier of a session which sends a message.
    */
    public final String sessionId;

    /**
    */
    public final String message;

    /**
    * Deprecated.
    */
    public final String targetId;

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

}