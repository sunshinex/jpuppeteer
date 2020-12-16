package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class AddRuleResponse {

    /**
    * The newly created rule.
    */
    public final CSSRule rule;

    public AddRuleResponse(CSSRule rule) {
        this.rule = rule;
    }

}