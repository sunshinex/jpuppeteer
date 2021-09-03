package jpuppeteer.cdp.client.entity.page;

/**
*/
public class OriginTrialToken {

    /**
    */
    public final String origin;

    /**
    */
    public final Boolean matchSubDomains;

    /**
    */
    public final String trialName;

    /**
    */
    public final java.math.BigDecimal expiryTime;

    /**
    */
    public final Boolean isThirdParty;

    /**
    */
    public final jpuppeteer.cdp.client.constant.page.OriginTrialUsageRestriction usageRestriction;

    public OriginTrialToken(String origin, Boolean matchSubDomains, String trialName, java.math.BigDecimal expiryTime, Boolean isThirdParty, jpuppeteer.cdp.client.constant.page.OriginTrialUsageRestriction usageRestriction) {
        this.origin = origin;
        this.matchSubDomains = matchSubDomains;
        this.trialName = trialName;
        this.expiryTime = expiryTime;
        this.isThirdParty = isThirdParty;
        this.usageRestriction = usageRestriction;
    }

}