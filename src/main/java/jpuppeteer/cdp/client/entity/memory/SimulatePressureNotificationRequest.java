package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class SimulatePressureNotificationRequest {

    /**
    * Memory pressure level of the notification.
    */
    public final jpuppeteer.cdp.client.constant.memory.PressureLevel level;

    public SimulatePressureNotificationRequest(jpuppeteer.cdp.client.constant.memory.PressureLevel level) {
        this.level = level;
    }

}