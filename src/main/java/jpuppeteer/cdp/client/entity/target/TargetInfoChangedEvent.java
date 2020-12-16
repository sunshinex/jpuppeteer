package jpuppeteer.cdp.client.entity.target;

/**
* Issued when some information about a target has changed. This only happens between `targetCreated` and `targetDestroyed`.
*/
public class TargetInfoChangedEvent {

    /**
    */
    public final TargetInfo targetInfo;

    public TargetInfoChangedEvent(TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

}