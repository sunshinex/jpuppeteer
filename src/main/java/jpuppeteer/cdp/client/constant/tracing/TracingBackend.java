package jpuppeteer.cdp.client.constant.tracing;

/**
* Backend type to use for tracing. `chrome` uses the Chrome-integrated tracing service and is supported on all platforms. `system` is only supported on Chrome OS and uses the Perfetto system tracing service. `auto` chooses `system` when the perfettoConfig provided to Tracing.start specifies at least one non-Chrome data source; otherwise uses `chrome`.
* experimental
*/
public enum TracingBackend implements jpuppeteer.cdp.client.CDPEnum {

    AUTO("auto"),
    CHROME("chrome"),
    SYSTEM("system"),
    ;

    private String value;

    TracingBackend(String value) {
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

    public static TracingBackend findByValue(String value) {
        for(TracingBackend val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}