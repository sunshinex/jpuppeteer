package jpuppeteer.cdp.cdp.entity.target;

/**
* Notifies about a new protocol message received from the session (as reported in `attachedToTarget` event).
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
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



}