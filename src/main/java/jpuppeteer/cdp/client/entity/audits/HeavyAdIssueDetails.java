package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class HeavyAdIssueDetails {

    /**
    * The resolution status, either blocking the content or warning.
    */
    private jpuppeteer.cdp.client.constant.audits.HeavyAdResolutionStatus resolution;

    /**
    * The reason the ad was blocked, total network or cpu or peak cpu.
    */
    private jpuppeteer.cdp.client.constant.audits.HeavyAdReason reason;

    /**
    * The frame that was blocked.
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedFrame frame;

    public void setResolution (jpuppeteer.cdp.client.constant.audits.HeavyAdResolutionStatus resolution) {
        this.resolution = resolution;
    }

    public jpuppeteer.cdp.client.constant.audits.HeavyAdResolutionStatus getResolution() {
        return this.resolution;
    }

    public void setReason (jpuppeteer.cdp.client.constant.audits.HeavyAdReason reason) {
        this.reason = reason;
    }

    public jpuppeteer.cdp.client.constant.audits.HeavyAdReason getReason() {
        return this.reason;
    }

    public void setFrame (jpuppeteer.cdp.client.entity.audits.AffectedFrame frame) {
        this.frame = frame;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedFrame getFrame() {
        return this.frame;
    }

    public HeavyAdIssueDetails(jpuppeteer.cdp.client.constant.audits.HeavyAdResolutionStatus resolution, jpuppeteer.cdp.client.constant.audits.HeavyAdReason reason, jpuppeteer.cdp.client.entity.audits.AffectedFrame frame) {
        this.resolution = resolution;
        this.reason = reason;
        this.frame = frame;
    }

    public HeavyAdIssueDetails() {
    }

}