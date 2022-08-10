package jpuppeteer.cdp.client.entity.page;

/**
*/
public class OriginTrial {

    /**
    */
    private String trialName;

    /**
    */
    private jpuppeteer.cdp.client.constant.page.OriginTrialStatus status;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrialTokenWithStatus> tokensWithStatus;

    public void setTrialName (String trialName) {
        this.trialName = trialName;
    }

    public String getTrialName() {
        return this.trialName;
    }

    public void setStatus (jpuppeteer.cdp.client.constant.page.OriginTrialStatus status) {
        this.status = status;
    }

    public jpuppeteer.cdp.client.constant.page.OriginTrialStatus getStatus() {
        return this.status;
    }

    public void setTokensWithStatus (java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrialTokenWithStatus> tokensWithStatus) {
        this.tokensWithStatus = tokensWithStatus;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrialTokenWithStatus> getTokensWithStatus() {
        return this.tokensWithStatus;
    }

    public OriginTrial(String trialName, jpuppeteer.cdp.client.constant.page.OriginTrialStatus status, java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrialTokenWithStatus> tokensWithStatus) {
        this.trialName = trialName;
        this.status = status;
        this.tokensWithStatus = tokensWithStatus;
    }

    public OriginTrial() {
    }

}