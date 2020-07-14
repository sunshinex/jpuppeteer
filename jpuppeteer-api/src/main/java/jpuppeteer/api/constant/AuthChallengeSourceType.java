package jpuppeteer.api.constant;

public enum AuthChallengeSourceType {

    SERVER("Server"),
    PROXY("Proxy"),
    ;

    private String value;

    AuthChallengeSourceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AuthChallengeSourceType findByValue(String value) {
        for(AuthChallengeSourceType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}
