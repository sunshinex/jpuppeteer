package jpuppeteer.cdp.client.constant.cachestorage;

/**
* type of HTTP response cached
* experimental
*/
public enum CachedResponseType implements jpuppeteer.cdp.client.CDPEnum {

    BASIC("basic"),
    CORS("cors"),
    DEFAULT("default"),
    ERROR("error"),
    OPAQUERESPONSE("opaqueResponse"),
    OPAQUEREDIRECT("opaqueRedirect"),
    ;

    private String value;

    CachedResponseType(String value) {
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

    public static CachedResponseType findByValue(String value) {
        for(CachedResponseType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}