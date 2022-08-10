package jpuppeteer.cdp.client.constant.page;

/**
* Indicates whether the frame is cross-origin isolated and why it is the case.
*/
public enum CrossOriginIsolatedContextType implements jpuppeteer.cdp.client.CDPEnum {

    ISOLATED("Isolated"),
    NOTISOLATED("NotIsolated"),
    NOTISOLATEDFEATUREDISABLED("NotIsolatedFeatureDisabled"),
    ;

    private String value;

    CrossOriginIsolatedContextType(String value) {
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

    public static CrossOriginIsolatedContextType findByValue(String value) {
        for(CrossOriginIsolatedContextType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}