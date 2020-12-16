package jpuppeteer.cdp.client.entity.css;

/**
* Inherited CSS rule collection from ancestor node.
* experimental
*/
public class InheritedStyleEntry {

    /**
    * The ancestor node's inline style, if any, in the style inheritance chain.
    */
    public final CSSStyle inlineStyle;

    /**
    * Matches of CSS rules matching the ancestor node in the style inheritance chain.
    */
    public final java.util.List<RuleMatch> matchedCSSRules;

    public InheritedStyleEntry(CSSStyle inlineStyle, java.util.List<RuleMatch> matchedCSSRules) {
        this.inlineStyle = inlineStyle;
        this.matchedCSSRules = matchedCSSRules;
    }

    public InheritedStyleEntry(java.util.List<RuleMatch> matchedCSSRules) {
        this.inlineStyle = null;
        this.matchedCSSRules = matchedCSSRules;
    }

}