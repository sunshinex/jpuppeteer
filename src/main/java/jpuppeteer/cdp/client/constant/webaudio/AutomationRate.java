package jpuppeteer.cdp.client.constant.webaudio;

/**
* Enum of AudioParam::AutomationRate from the spec
* experimental
*/
public enum AutomationRate implements jpuppeteer.cdp.client.CDPEnum {

    A_RATE("a-rate"),
    K_RATE("k-rate"),
    ;

    private String value;

    AutomationRate(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static AutomationRate findByValue(String value) {
        for(AutomationRate val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}