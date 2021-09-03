package jpuppeteer.cdp.client.constant.network;

/**
* The reason why request was blocked.
*/
public enum BlockedReason implements jpuppeteer.cdp.client.CDPEnum {

    OTHER("other"),
    CSP("csp"),
    MIXED_CONTENT("mixed-content"),
    ORIGIN("origin"),
    INSPECTOR("inspector"),
    SUBRESOURCE_FILTER("subresource-filter"),
    CONTENT_TYPE("content-type"),
    COEP_FRAME_RESOURCE_NEEDS_COEP_HEADER("coep-frame-resource-needs-coep-header"),
    COOP_SANDBOXED_IFRAME_CANNOT_NAVIGATE_TO_COOP_PAGE("coop-sandboxed-iframe-cannot-navigate-to-coop-page"),
    CORP_NOT_SAME_ORIGIN("corp-not-same-origin"),
    CORP_NOT_SAME_ORIGIN_AFTER_DEFAULTED_TO_SAME_ORIGIN_BY_COEP("corp-not-same-origin-after-defaulted-to-same-origin-by-coep"),
    CORP_NOT_SAME_SITE("corp-not-same-site"),
    ;

    private String value;

    BlockedReason(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static BlockedReason findByValue(String value) {
        for(BlockedReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}