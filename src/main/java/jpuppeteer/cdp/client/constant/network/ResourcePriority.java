package jpuppeteer.cdp.client.constant.network;

/**
* Loading priority of a resource request.
*/
public enum ResourcePriority implements jpuppeteer.cdp.client.CDPEnum {

    VERYLOW("VeryLow"),
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    VERYHIGH("VeryHigh"),
    ;

    private String value;

    ResourcePriority(String value) {
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

    public static ResourcePriority findByValue(String value) {
        for(ResourcePriority val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}