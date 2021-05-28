package jpuppeteer.cdp.client.entity.page;

/**
*/
public class OriginTrial {

    /**
    */
    public final String trialName;

    /**
    */
    public final jpuppeteer.cdp.client.constant.page.OriginTrialStatus status;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrialTokenWithStatus> tokensWithStatus;

    public OriginTrial(String trialName, jpuppeteer.cdp.client.constant.page.OriginTrialStatus status, java.util.List<jpuppeteer.cdp.client.entity.page.OriginTrialTokenWithStatus> tokensWithStatus) {
        this.trialName = trialName;
        this.status = status;
        this.tokensWithStatus = tokensWithStatus;
    }

}