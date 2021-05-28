package jpuppeteer.cdp.client.constant.page;

/**
* Reason for a permissions policy feature to be disabled.
*/
public enum PermissionsPolicyBlockReason implements jpuppeteer.cdp.client.CDPEnum {

    HEADER("Header"),
    IFRAMEATTRIBUTE("IframeAttribute"),
    ;

    private String value;

    PermissionsPolicyBlockReason(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static PermissionsPolicyBlockReason findByValue(String value) {
        for(PermissionsPolicyBlockReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}