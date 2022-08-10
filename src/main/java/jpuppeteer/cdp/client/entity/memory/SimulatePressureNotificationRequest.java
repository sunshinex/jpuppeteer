package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class SimulatePressureNotificationRequest {

    /**
    * Memory pressure level of the notification.
    */
    private jpuppeteer.cdp.client.constant.memory.PressureLevel level;

    public void setLevel (jpuppeteer.cdp.client.constant.memory.PressureLevel level) {
        this.level = level;
    }

    public jpuppeteer.cdp.client.constant.memory.PressureLevel getLevel() {
        return this.level;
    }

    public SimulatePressureNotificationRequest(jpuppeteer.cdp.client.constant.memory.PressureLevel level) {
        this.level = level;
    }

    public SimulatePressureNotificationRequest() {
    }

}