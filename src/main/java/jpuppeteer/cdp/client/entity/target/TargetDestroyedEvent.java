package jpuppeteer.cdp.client.entity.target;

/**
* Issued when a target is destroyed.
*/
public class TargetDestroyedEvent {

    /**
    */
    private String targetId;

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public TargetDestroyedEvent(String targetId) {
        this.targetId = targetId;
    }

    public TargetDestroyedEvent() {
    }

}