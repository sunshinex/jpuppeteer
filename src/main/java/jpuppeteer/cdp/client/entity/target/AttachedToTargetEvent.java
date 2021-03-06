package jpuppeteer.cdp.client.entity.target;

/**
* Issued when attached to target because of auto-attach or `attachToTarget` command.
*/
public class AttachedToTargetEvent {

    /**
    * Identifier assigned to the session used to send/receive messages.
    */
    public final String sessionId;

    /**
    */
    public final TargetInfo targetInfo;

    /**
    */
    public final Boolean waitingForDebugger;

    public AttachedToTargetEvent(String sessionId, TargetInfo targetInfo, Boolean waitingForDebugger) {
        this.sessionId = sessionId;
        this.targetInfo = targetInfo;
        this.waitingForDebugger = waitingForDebugger;
    }

}