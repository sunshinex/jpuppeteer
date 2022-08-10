package jpuppeteer.cdp.client.entity.target;

/**
* Issued when some information about a target has changed. This only happens between `targetCreated` and `targetDestroyed`.
*/
public class TargetInfoChangedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo;

    public void setTargetInfo (jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

    public jpuppeteer.cdp.client.entity.target.TargetInfo getTargetInfo() {
        return this.targetInfo;
    }

    public TargetInfoChangedEvent(jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

    public TargetInfoChangedEvent() {
    }

}