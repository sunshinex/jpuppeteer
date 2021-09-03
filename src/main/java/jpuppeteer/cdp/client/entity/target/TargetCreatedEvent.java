package jpuppeteer.cdp.client.entity.target;

/**
* Issued when a possible inspection target is created.
*/
public class TargetCreatedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo;

    public TargetCreatedEvent(jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

}