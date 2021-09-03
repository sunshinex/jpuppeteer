package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class HeavyAdIssueDetails {

    /**
    * The resolution status, either blocking the content or warning.
    */
    public final jpuppeteer.cdp.client.constant.audits.HeavyAdResolutionStatus resolution;

    /**
    * The reason the ad was blocked, total network or cpu or peak cpu.
    */
    public final jpuppeteer.cdp.client.constant.audits.HeavyAdReason reason;

    /**
    * The frame that was blocked.
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedFrame frame;

    public HeavyAdIssueDetails(jpuppeteer.cdp.client.constant.audits.HeavyAdResolutionStatus resolution, jpuppeteer.cdp.client.constant.audits.HeavyAdReason reason, jpuppeteer.cdp.client.entity.audits.AffectedFrame frame) {
        this.resolution = resolution;
        this.reason = reason;
        this.frame = frame;
    }

}