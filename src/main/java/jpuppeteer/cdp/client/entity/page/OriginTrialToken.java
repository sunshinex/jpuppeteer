package jpuppeteer.cdp.client.entity.page;

/**
*/
public class OriginTrialToken {

    /**
    */
    private String origin;

    /**
    */
    private Boolean matchSubDomains;

    /**
    */
    private String trialName;

    /**
    */
    private java.math.BigDecimal expiryTime;

    /**
    */
    private Boolean isThirdParty;

    /**
    */
    private jpuppeteer.cdp.client.constant.page.OriginTrialUsageRestriction usageRestriction;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setMatchSubDomains (Boolean matchSubDomains) {
        this.matchSubDomains = matchSubDomains;
    }

    public Boolean getMatchSubDomains() {
        return this.matchSubDomains;
    }

    public void setTrialName (String trialName) {
        this.trialName = trialName;
    }

    public String getTrialName() {
        return this.trialName;
    }

    public void setExpiryTime (java.math.BigDecimal expiryTime) {
        this.expiryTime = expiryTime;
    }

    public java.math.BigDecimal getExpiryTime() {
        return this.expiryTime;
    }

    public void setIsThirdParty (Boolean isThirdParty) {
        this.isThirdParty = isThirdParty;
    }

    public Boolean getIsThirdParty() {
        return this.isThirdParty;
    }

    public void setUsageRestriction (jpuppeteer.cdp.client.constant.page.OriginTrialUsageRestriction usageRestriction) {
        this.usageRestriction = usageRestriction;
    }

    public jpuppeteer.cdp.client.constant.page.OriginTrialUsageRestriction getUsageRestriction() {
        return this.usageRestriction;
    }

    public OriginTrialToken(String origin, Boolean matchSubDomains, String trialName, java.math.BigDecimal expiryTime, Boolean isThirdParty, jpuppeteer.cdp.client.constant.page.OriginTrialUsageRestriction usageRestriction) {
        this.origin = origin;
        this.matchSubDomains = matchSubDomains;
        this.trialName = trialName;
        this.expiryTime = expiryTime;
        this.isThirdParty = isThirdParty;
        this.usageRestriction = usageRestriction;
    }

    public OriginTrialToken() {
    }

}