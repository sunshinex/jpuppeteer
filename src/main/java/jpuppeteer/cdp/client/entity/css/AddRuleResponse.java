package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class AddRuleResponse {

    /**
    * The newly created rule.
    */
    public final jpuppeteer.cdp.client.entity.css.CSSRule rule;

    public AddRuleResponse(jpuppeteer.cdp.client.entity.css.CSSRule rule) {
        this.rule = rule;
    }

}