package jpuppeteer.cdp.client.constant.backgroundservice;

/**
* The Background Service that will be associated with the commands/events. Every Background Service operates independently, but they share the same API.
* experimental
*/
public enum ServiceName implements jpuppeteer.cdp.client.CDPEnum {

    BACKGROUNDFETCH("backgroundFetch"),
    BACKGROUNDSYNC("backgroundSync"),
    PUSHMESSAGING("pushMessaging"),
    NOTIFICATIONS("notifications"),
    PAYMENTHANDLER("paymentHandler"),
    PERIODICBACKGROUNDSYNC("periodicBackgroundSync"),
    ;

    private String value;

    ServiceName(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static ServiceName findByValue(String value) {
        for(ServiceName val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}