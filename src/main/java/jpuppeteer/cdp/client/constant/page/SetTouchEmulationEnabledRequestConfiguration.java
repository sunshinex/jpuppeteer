package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum SetTouchEmulationEnabledRequestConfiguration implements jpuppeteer.cdp.client.CDPEnum {

    MOBILE("mobile"),
    DESKTOP("desktop"),
    ;

    private String value;

    SetTouchEmulationEnabledRequestConfiguration(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SetTouchEmulationEnabledRequestConfiguration findByValue(String value) {
        for(SetTouchEmulationEnabledRequestConfiguration val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}