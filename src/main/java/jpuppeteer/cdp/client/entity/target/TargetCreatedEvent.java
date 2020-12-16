package jpuppeteer.cdp.client.entity.target;

/**
* Issued when a possible inspection target is created.
*/
public class TargetCreatedEvent {

    /**
    */
    public final TargetInfo targetInfo;

    public TargetCreatedEvent(TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

}