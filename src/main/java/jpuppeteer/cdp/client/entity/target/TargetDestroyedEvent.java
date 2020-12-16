package jpuppeteer.cdp.client.entity.target;

/**
* Issued when a target is destroyed.
*/
public class TargetDestroyedEvent {

    /**
    */
    public final String targetId;

    public TargetDestroyedEvent(String targetId) {
        this.targetId = targetId;
    }

}