package jpuppeteer.cdp.client.entity.audits;

/**
* Details for a request that has been blocked with the BLOCKED_BY_RESPONSE code. Currently only used for COEP/COOP, but may be extended to include some CSP errors in the future.
* experimental
*/
public class BlockedByResponseIssueDetails {

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedFrame parentFrame;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedFrame blockedFrame;

    /**
    */
    private jpuppeteer.cdp.client.constant.audits.BlockedByResponseReason reason;

    public void setRequest (jpuppeteer.cdp.client.entity.audits.AffectedRequest request) {
        this.request = request;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedRequest getRequest() {
        return this.request;
    }

    public void setParentFrame (jpuppeteer.cdp.client.entity.audits.AffectedFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedFrame getParentFrame() {
        return this.parentFrame;
    }

    public void setBlockedFrame (jpuppeteer.cdp.client.entity.audits.AffectedFrame blockedFrame) {
        this.blockedFrame = blockedFrame;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedFrame getBlockedFrame() {
        return this.blockedFrame;
    }

    public void setReason (jpuppeteer.cdp.client.constant.audits.BlockedByResponseReason reason) {
        this.reason = reason;
    }

    public jpuppeteer.cdp.client.constant.audits.BlockedByResponseReason getReason() {
        return this.reason;
    }

    public BlockedByResponseIssueDetails(jpuppeteer.cdp.client.entity.audits.AffectedRequest request, jpuppeteer.cdp.client.entity.audits.AffectedFrame parentFrame, jpuppeteer.cdp.client.entity.audits.AffectedFrame blockedFrame, jpuppeteer.cdp.client.constant.audits.BlockedByResponseReason reason) {
        this.request = request;
        this.parentFrame = parentFrame;
        this.blockedFrame = blockedFrame;
        this.reason = reason;
    }

    public BlockedByResponseIssueDetails(jpuppeteer.cdp.client.entity.audits.AffectedRequest request, jpuppeteer.cdp.client.constant.audits.BlockedByResponseReason reason) {
        this.request = request;
        this.parentFrame = null;
        this.blockedFrame = null;
        this.reason = reason;
    }

    public BlockedByResponseIssueDetails() {
    }

}