package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum InitiatorType implements jpuppeteer.cdp.client.CDPEnum {

    PARSER("parser"),
    SCRIPT("script"),
    PRELOAD("preload"),
    SIGNEDEXCHANGE("SignedExchange"),
    PREFLIGHT("preflight"),
    OTHER("other"),
    ;

    private String value;

    InitiatorType(String value) {
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

    public static InitiatorType findByValue(String value) {
        for(InitiatorType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}