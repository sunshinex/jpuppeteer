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
    ;

    private String value;

    ClientNavigationReason(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ClientNavigationReason findByValue(String value) {
        for(ClientNavigationReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}