package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetMatchedStylesForNodeResponse {

    /**
    * Inline style for the specified DOM node.
    */
    public final jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle;

    /**
    * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
    */
    public final jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle;

    /**
    * CSS rules matching this node, from all applicable stylesheets.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matchedCSSRules;

    /**
    * Pseudo style matches for this node.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.PseudoElementMatches> pseudoElements;

    /**
    * A chain of inherited styles (from the immediate node parent up to the DOM tree root).
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.InheritedStyleEntry> inherited;

    /**
    * A list of CSS keyframed animations matching this node.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframesRule> cssKeyframesRules;

    public GetMatchedStylesForNodeResponse(jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle, jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle, java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matchedCSSRules, java.util.List<jpuppeteer.cdp.client.entity.css.PseudoElementMatches> pseudoElements, java.util.List<jpuppeteer.cdp.client.entity.css.InheritedStyleEntry> inherited, java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframesRule> cssKeyframesRules) {
        this.inlineStyle = inlineStyle;
        this.attributesStyle = attributesStyle;
        this.matchedCSSRules = matchedCSSRules;
        this.pseudoElements = pseudoElements;
        this.inherited = inherited;
        this.cssKeyframesRules = cssKeyframesRules;
    }

    public GetMatchedStylesForNodeResponse() {
        this.inlineStyle = null;
        this.attributesStyle = null;
        this.matchedCSSRules = null;
        this.pseudoElements = null;
        this.inherited = null;
        this.cssKeyframesRules = null;
    }

}