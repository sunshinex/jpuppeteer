package jpuppeteer.cdp.client.constant.network;

/**
*/
public enum IPAddressSpace implements jpuppeteer.cdp.client.CDPEnum {

    LOCAL("Local"),
    PRIVATE("Private"),
    PUBLIC("Public"),
    UNKNOWN("Unknown"),
    ;

    private String value;

    IPAddressSpace(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static IPAddressSpace findByValue(String value) {
        for(IPAddressSpace val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}