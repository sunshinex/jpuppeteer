package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum CrossOriginOpenerPolicyValue implements jpuppeteer.cdp.client.CDPEnum {

    SAMEORIGIN("SameOrigin"),
    SAMEORIGINALLOWPOPUPS("SameOriginAllowPopups"),
    UNSAFENONE("UnsafeNone"),
    SAMEORIGINPLUSCOEP("SameOriginPlusCoep"),
    ;

    private String value;

    CrossOriginOpenerPolicyValue(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static CrossOriginOpenerPolicyValue findByValue(String value) {
        for(CrossOriginOpenerPolicyValue val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}