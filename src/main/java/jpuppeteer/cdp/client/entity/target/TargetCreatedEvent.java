package jpuppeteer.cdp.client.entity.target;

/**
* Issued when a possible inspection target is created.
*/
public class TargetCreatedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo;

    public void setTargetInfo (jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

    public jpuppeteer.cdp.client.entity.target.TargetInfo getTargetInfo() {
        return this.targetInfo;
    }

    public TargetCreatedEvent(jpuppeteer.cdp.client.entity.target.TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }

    public TargetCreatedEvent() {
    }

}