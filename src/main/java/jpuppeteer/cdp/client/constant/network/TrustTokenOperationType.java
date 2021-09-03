package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum TrustTokenOperationType implements jpuppeteer.cdp.client.CDPEnum {

    ISSUANCE("Issuance"),
    REDEMPTION("Redemption"),
    SIGNING("Signing"),
    ;

    private String value;

    TrustTokenOperationType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static TrustTokenOperationType findByValue(String value) {
        for(TrustTokenOperationType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}