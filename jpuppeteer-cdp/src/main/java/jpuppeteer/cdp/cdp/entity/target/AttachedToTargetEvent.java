package jpuppeteer.cdp.cdp.entity.target;

/**
* Issued when attached to target because of auto-attach or `attachToTarget` command.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class AttachedToTargetEvent {

    /**
    * Identifier assigned to the session used to send/receive messages.
    */
    private String sessionId;

    /**
    */
    private jpuppeteer.cdp.cdp.entity.target.TargetInfo targetInfo;

    /**
    */
    private Boolean waitingForDebugger;



}