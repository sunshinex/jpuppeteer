package jpuppeteer.cdp.client.constant.security;

/**
* A description of mixed content (HTTP resources on HTTPS pages), as defined by https://www.w3.org/TR/mixed-content/#categories
*/
public enum MixedContentType implements jpuppeteer.cdp.client.CDPEnum {

    BLOCKABLE("blockable"),
    OPTIONALLY_BLOCKABLE("optionally-blockable"),
    NONE("none"),
    ;

    private String value;

    MixedContentType(String value) {
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

    public static MixedContentType findByValue(String value) {
        for(MixedContentType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}