package jpuppeteer.cdp.client.constant.emulation;

/**
*/
public enum SetEmitTouchEventsForMouseRequestConfiguration implements jpuppeteer.cdp.client.CDPEnum {

    MOBILE("mobile"),
    DESKTOP("desktop"),
    ;

    private String value;

    SetEmitTouchEventsForMouseRequestConfiguration(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SetEmitTouchEventsForMouseRequestConfiguration findByValue(String value) {
        for(SetEmitTouchEventsForMouseRequestConfiguration val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}