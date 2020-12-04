package jpuppeteer.cdp.client.entity.target;

/**
* Issued when some information about a target has changed. This only happens between `targetCreated` and `targetDestroyed`.
*/
public class TargetInfoChangedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo;

    public TargetInfoChangedEvent(jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

}