package jpuppeteer.cdp.client.entity.css;

/**
* Inherited CSS rule collection from ancestor node.
* experimental
*/
public class InheritedStyleEntry {

    /**
    * The ancestor node's inline style, if any, in the style inheritance chain.
    */
    private jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle;

    /**
    * Matches of CSS rules matching the ancestor node in the style inheritance chain.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matchedCSSRules;

    public void setInlineStyle (jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle) {
        this.inlineStyle = inlineStyle;
    }

    public jpuppeteer.cdp.client.entity.css.CSSStyle getInlineStyle() {
        return this.inlineStyle;
    }

    public void setMatchedCSSRules (java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matchedCSSRules) {
        this.matchedCSSRules = matchedCSSRules;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> getMatchedCSSRules() {
        return this.matchedCSSRules;
    }

    public InheritedStyleEntry(jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle, java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matchedCSSRules) {
        this.inlineStyle = inlineStyle;
        this.matchedCSSRules = matchedCSSRules;
    }

    public InheritedStyleEntry(java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matchedCSSRules) {
        this.inlineStyle = null;
        this.matchedCSSRules = matchedCSSRules;
    }

    public InheritedStyleEntry() {
    }

}