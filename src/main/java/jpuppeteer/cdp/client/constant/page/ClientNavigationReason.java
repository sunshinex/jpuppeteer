package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum ClientNavigationReason implements jpuppeteer.cdp.client.CDPEnum {

    FORMSUBMISSIONGET("formSubmissionGet"),
    FORMSUBMISSIONPOST("formSubmissionPost"),
    HTTPHEADERREFRESH("httpHeaderRefresh"),
    SCRIPTINITIATED("scriptInitiated"),
    METATAGREFRESH("metaTagRefresh"),
    PAGEBLOCKINTERSTITIAL("pageBlockInterstitial"),
    RELOAD("reload"),
    ANCHORCLICK("anchorClick"),
    ;

    private String value;

    ClientNavigationReason(String value) {
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

    public static ClientNavigationReason findByValue(String value) {
        for(ClientNavigationReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}