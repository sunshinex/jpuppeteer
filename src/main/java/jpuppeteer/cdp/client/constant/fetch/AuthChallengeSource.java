package jpuppeteer.cdp.client.constant.fetch;

/**
* experimental
*/
public enum AuthChallengeSource implements jpuppeteer.cdp.client.CDPEnum {

    SERVER("Server"),
    PROXY("Proxy"),
    ;

    private String value;

    AuthChallengeSource(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static AuthChallengeSource findByValue(String value) {
        for(AuthChallengeSource val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}