package jpuppeteer.cdp.client.constant.security;

/**
*/
public enum SafetyTipStatus implements jpuppeteer.cdp.client.CDPEnum {

    BADREPUTATION("badReputation"),
    LOOKALIKE("lookalike"),
    ;

    private String value;

    SafetyTipStatus(String value) {
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

    public static SafetyTipStatus findByValue(String value) {
        for(SafetyTipStatus val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}