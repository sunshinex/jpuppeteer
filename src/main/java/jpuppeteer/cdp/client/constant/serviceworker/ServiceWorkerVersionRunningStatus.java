package jpuppeteer.cdp.client.constant.serviceworker;

/**
* experimental
*/
public enum ServiceWorkerVersionRunningStatus implements jpuppeteer.cdp.client.CDPEnum {

    STOPPED("stopped"),
    STARTING("starting"),
    RUNNING("running"),
    STOPPING("stopping"),
    ;

    private String value;

    ServiceWorkerVersionRunningStatus(String value) {
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

    public static ServiceWorkerVersionRunningStatus findByValue(String value) {
        for(ServiceWorkerVersionRunningStatus val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}