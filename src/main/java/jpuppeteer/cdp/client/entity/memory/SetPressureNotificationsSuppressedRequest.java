package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class SetPressureNotificationsSuppressedRequest {

    /**
    * If true, memory pressure notifications will be suppressed.
    */
    public final Boolean suppressed;

    public SetPressureNotificationsSuppressedRequest(Boolean suppressed) {
        this.suppressed = suppressed;
    }

}