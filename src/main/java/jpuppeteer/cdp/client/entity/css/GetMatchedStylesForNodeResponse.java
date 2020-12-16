package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetMatchedStylesForNodeResponse {

    /**
    * Inline style for the specified DOM node.
    */
    public final CSSStyle inlineStyle;

    /**
    * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
    */
    public final CSSStyle attributesStyle;

    /**
    * CSS rules matching this node, from all applicable stylesheets.
    */
    public final java.util.List<RuleMatch> matchedCSSRules;

    /**
    * Pseudo style matches for this node.
    */
    public final java.util.List<PseudoElementMatches> pseudoElements;

    /**
    * A chain of inherited styles (from the immediate node parent up to the DOM tree root).
    */
    public final java.util.List<InheritedStyleEntry> inherited;

    /**
    * A list of CSS keyframed animations matching this node.
    */
    public final java.util.List<CSSKeyframesRule> cssKeyframesRules;

    public GetMatchedStylesForNodeResponse(CSSStyle inlineStyle, CSSStyle attributesStyle, java.util.List<RuleMatch> matchedCSSRules, java.util.List<PseudoElementMatches> pseudoElements, java.util.List<InheritedStyleEntry> inherited, java.util.List<CSSKeyframesRule> cssKeyframesRules) {
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