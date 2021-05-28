package jpuppeteer.cdp.client.constant.network;

/**
* Source of serviceworker response.
*/
public enum ServiceWorkerResponseSource implements jpuppeteer.cdp.client.CDPEnum {

    CACHE_STORAGE("cache-storage"),
    HTTP_CACHE("http-cache"),
    FALLBACK_CODE("fallback-code"),
    NETWORK("network"),
    ;

    private String value;

    ServiceWorkerResponseSource(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ServiceWorkerResponseSource findByValue(String value) {
        for(ServiceWorkerResponseSource val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}