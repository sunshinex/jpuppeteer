package jpuppeteer.cdp.client.entity.audits;

/**
* Details for a request that has been blocked with the BLOCKED_BY_RESPONSE code. Currently only used for COEP/COOP, but may be extended to include some CSP errors in the future.
* experimental
*/
public class BlockedByResponseIssueDetails {

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedFrame parentFrame;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedFrame blockedFrame;

    /**
    */
    public final jpuppeteer.cdp.client.constant.audits.BlockedByResponseReason reason;

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

}