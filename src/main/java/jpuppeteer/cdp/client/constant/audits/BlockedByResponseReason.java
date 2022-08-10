package jpuppeteer.cdp.client.constant.audits;

/**
* Enum indicating the reason a response has been blocked. These reasons are refinements of the net error BLOCKED_BY_RESPONSE.
* experimental
*/
public enum BlockedByResponseReason implements jpuppeteer.cdp.client.CDPEnum {

    COEPFRAMERESOURCENEEDSCOEPHEADER("CoepFrameResourceNeedsCoepHeader"),
    COOPSANDBOXEDIFRAMECANNOTNAVIGATETOCOOPPAGE("CoopSandboxedIFrameCannotNavigateToCoopPage"),
    CORPNOTSAMEORIGIN("CorpNotSameOrigin"),
    CORPNOTSAMEORIGINAFTERDEFAULTEDTOSAMEORIGINBYCOEP("CorpNotSameOriginAfterDefaultedToSameOriginByCoep"),
    CORPNOTSAMESITE("CorpNotSameSite"),
    ;

    private String value;

    BlockedByResponseReason(String value) {
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

    public static BlockedByResponseReason findByValue(String value) {
        for(BlockedByResponseReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}