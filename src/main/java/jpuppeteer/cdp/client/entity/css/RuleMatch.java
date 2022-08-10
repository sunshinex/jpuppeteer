package jpuppeteer.cdp.client.entity.css;

/**
* Match data for a CSS rule.
* experimental
*/
public class RuleMatch {

    /**
    * CSS rule in the match.
    */
    private jpuppeteer.cdp.client.entity.css.CSSRule rule;

    /**
    * Matching selector indices in the rule's selectorList selectors (0-based).
    */
    private java.util.List<Integer> matchingSelectors;

    public void setRule (jpuppeteer.cdp.client.entity.css.CSSRule rule) {
        this.rule = rule;
    }

    public jpuppeteer.cdp.client.entity.css.CSSRule getRule() {
        return this.rule;
    }

    public void setMatchingSelectors (java.util.List<Integer> matchingSelectors) {
        this.matchingSelectors = matchingSelectors;
    }

    public java.util.List<Integer> getMatchingSelectors() {
        return this.matchingSelectors;
    }

    public RuleMatch(jpuppeteer.cdp.client.entity.css.CSSRule rule, java.util.List<Integer> matchingSelectors) {
        this.rule = rule;
        this.matchingSelectors = matchingSelectors;
    }

    public RuleMatch() {
    }

}