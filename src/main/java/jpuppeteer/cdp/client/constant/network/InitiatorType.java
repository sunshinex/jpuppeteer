package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum InitiatorType implements jpuppeteer.cdp.client.CDPEnum {

    PARSER("parser"),
    SCRIPT("script"),
    PRELOAD("preload"),
    SIGNEDEXCHANGE("SignedExchange"),
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

    public static InitiatorType findByValue(String value) {
        for(InitiatorType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}