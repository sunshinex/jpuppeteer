package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum CrossOriginEmbedderPolicyValue implements jpuppeteer.cdp.client.CDPEnum {

    NONE("None"),
    CORSORCREDENTIALLESS("CorsOrCredentialless"),
    REQUIRECORP("RequireCorp"),
    ;

    private String value;

    CrossOriginEmbedderPolicyValue(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static CrossOriginEmbedderPolicyValue findByValue(String value) {
        for(CrossOriginEmbedderPolicyValue val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}