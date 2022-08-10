package jpuppeteer.cdp.client.constant.serviceworker;

/**
* experimental
*/
public enum ServiceWorkerVersionStatus implements jpuppeteer.cdp.client.CDPEnum {

    NEW("new"),
    INSTALLING("installing"),
    INSTALLED("installed"),
    ACTIVATING("activating"),
    ACTIVATED("activated"),
    REDUNDANT("redundant"),
    ;

    private String value;

    ServiceWorkerVersionStatus(String value) {
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

    public static ServiceWorkerVersionStatus findByValue(String value) {
        for(ServiceWorkerVersionStatus val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}