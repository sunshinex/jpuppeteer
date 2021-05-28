package jpuppeteer.cdp.client.constant.emulation;

/**
*/
public enum DisplayFeatureOrientation implements jpuppeteer.cdp.client.CDPEnum {

    VERTICAL("vertical"),
    HORIZONTAL("horizontal"),
    ;

    private String value;

    DisplayFeatureOrientation(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static DisplayFeatureOrientation findByValue(String value) {
        for(DisplayFeatureOrientation val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}