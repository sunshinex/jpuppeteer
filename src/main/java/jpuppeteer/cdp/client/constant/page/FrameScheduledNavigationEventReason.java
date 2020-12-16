package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum FrameScheduledNavigationEventReason implements jpuppeteer.cdp.client.CDPEnum {

    FORMSUBMISSIONGET("formSubmissionGet"),
    FORMSUBMISSIONPOST("formSubmissionPost"),
    HTTPHEADERREFRESH("httpHeaderRefresh"),
    SCRIPTINITIATED("scriptInitiated"),
    METATAGREFRESH("metaTagRefresh"),
    PAGEBLOCKINTERSTITIAL("pageBlockInterstitial"),
    RELOAD("reload"),
    ;

    private String value;

    FrameScheduledNavigationEventReason(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static FrameScheduledNavigationEventReason findByValue(String value) {
        for(FrameScheduledNavigationEventReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}