package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class StopRuleUsageTrackingResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> ruleUsage;

    public void setRuleUsage (java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> ruleUsage) {
        this.ruleUsage = ruleUsage;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> getRuleUsage() {
        return this.ruleUsage;
    }

    public StopRuleUsageTrackingResponse(java.util.List<jpuppeteer.cdp.client.entity.css.RuleUsage> ruleUsage) {
        this.ruleUsage = ruleUsage;
    }

    public StopRuleUsageTrackingResponse() {
    }

}