package jpuppeteer.cdp.client.constant.fetch;

/**
*/
public enum AuthChallengeResponseResponse implements jpuppeteer.cdp.client.CDPEnum {

    DEFAULT("Default"),
    CANCELAUTH("CancelAuth"),
    PROVIDECREDENTIALS("ProvideCredentials"),
    ;

    private String value;

    AuthChallengeResponseResponse(String value) {
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

    public static AuthChallengeResponseResponse findByValue(String value) {
        for(AuthChallengeResponseResponse val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}