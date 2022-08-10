package jpuppeteer.cdp.client.entity.target;

/**
* Issued when attached to target because of auto-attach or `attachToTarget` command.
*/
public class AttachedToTargetEvent {

    /**
    * Identifier assigned to the session used to send/receive messages.
    */
    private String sessionId;

    /**
    */
    private jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo;

    /**
    */
    private Boolean waitingForDebugger;

    public void setSessionId (String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setTargetInfo (jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

    public jpuppeteer.cdp.client.entity.target.TargetInfo getTargetInfo() {
        return this.targetInfo;
    }

    public void setWaitingForDebugger (Boolean waitingForDebugger) {
        this.waitingForDebugger = waitingForDebugger;
    }

    public Boolean getWaitingForDebugger() {
        return this.waitingForDebugger;
    }

    public AttachedToTargetEvent(String sessionId, jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo, Boolean waitingForDebugger) {
        this.sessionId = sessionId;
        this.targetInfo = targetInfo;
        this.waitingForDebugger = waitingForDebugger;
    }

    public AttachedToTargetEvent() {
    }

}