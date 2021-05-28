package jpuppeteer.cdp.client.entity.css;

/**
* Match data for a CSS rule.
* experimental
*/
public class RuleMatch {

    /**
    * CSS rule in the match.
    */
    public final jpuppeteer.cdp.client.entity.css.CSSRule rule;

    /**
    * Matching selector indices in the rule's selectorList selectors (0-based).
    */
    public final java.util.List<Integer> matchingSelectors;

    public RuleMatch(jpuppeteer.cdp.client.entity.css.CSSRule rule, java.util.List<Integer> matchingSelectors) {
        this.rule = rule;
        this.matchingSelectors = matchingSelectors;
    }

}