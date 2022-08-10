package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class AddRuleResponse {

    /**
    * The newly created rule.
    */
    private jpuppeteer.cdp.client.entity.css.CSSRule rule;

    public void setRule (jpuppeteer.cdp.client.entity.css.CSSRule rule) {
        this.rule = rule;
    }

    public jpuppeteer.cdp.client.entity.css.CSSRule getRule() {
        return this.rule;
    }

    public AddRuleResponse(jpuppeteer.cdp.client.entity.css.CSSRule rule) {
        this.rule = rule;
    }

    public AddRuleResponse() {
    }

}