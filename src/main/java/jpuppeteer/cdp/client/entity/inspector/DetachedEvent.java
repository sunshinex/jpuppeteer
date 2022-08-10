package jpuppeteer.cdp.client.entity.inspector;

/**
* Fired when remote debugging connection is about to be terminated. Contains detach reason.
* experimental
*/
public class DetachedEvent {

    /**
    * The reason why connection has been terminated.
    */
    private String reason;

    public void setReason (String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public DetachedEvent(String reason) {
        this.reason = reason;
    }

    public DetachedEvent() {
    }

}