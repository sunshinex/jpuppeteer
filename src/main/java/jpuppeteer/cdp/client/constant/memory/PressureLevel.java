package jpuppeteer.cdp.client.constant.memory;

/**
* Memory pressure level.
* experimental
*/
public enum PressureLevel implements jpuppeteer.cdp.client.CDPEnum {

    MODERATE("moderate"),
    CRITICAL("critical"),
    ;

    private String value;

    PressureLevel(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static PressureLevel findByValue(String value) {
        for(PressureLevel val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}