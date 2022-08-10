package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class SetPressureNotificationsSuppressedRequest {

    /**
    * If true, memory pressure notifications will be suppressed.
    */
    private Boolean suppressed;

    public void setSuppressed (Boolean suppressed) {
        this.suppressed = suppressed;
    }

    public Boolean getSuppressed() {
        return this.suppressed;
    }

    public SetPressureNotificationsSuppressedRequest(Boolean suppressed) {
        this.suppressed = suppressed;
    }

    public SetPressureNotificationsSuppressedRequest() {
    }

}