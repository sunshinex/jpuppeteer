package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class SimulatePressureNotificationRequest {

    /**
    * Memory pressure level of the notification.
    */
    public final String level;

    public SimulatePressureNotificationRequest(String level) {
        this.level = level;
    }

}