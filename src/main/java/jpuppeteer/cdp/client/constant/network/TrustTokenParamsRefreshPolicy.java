package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum TrustTokenParamsRefreshPolicy implements jpuppeteer.cdp.client.CDPEnum {

    USECACHED("UseCached"),
    REFRESH("Refresh"),
    ;

    private String value;

    TrustTokenParamsRefreshPolicy(String value) {
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

    public static TrustTokenParamsRefreshPolicy findByValue(String value) {
        for(TrustTokenParamsRefreshPolicy val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}