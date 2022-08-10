package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetMatchedStylesForNodeResponse {

    /**
    * Inline style for the specified DOM node.
    */
    private jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle;

    /**
    * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
    */
    private jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle;

    /**
    * CSS rules matching this node, from all applicable stylesheets.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matchedCSSRules;

    /**
    * Pseudo style matches for this node.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.PseudoElementMatches> pseudoElements;

    /**
    * A chain of inherited styles (from the immediate node parent up to the DOM tree root).
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.InheritedStyleEntry> inherited;

    /**
    * A list of CSS keyframed animations matching this node.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframesRule> cssKeyframesRules;

    public void setInlineStyle (jpuppeteer.cdp.client.entity.css.CSSStyle inlineStyle) {
        this.inlineStyle = inlineStyle;
    }

    public jpuppeteer.cdp.client.entity.css.CSSStyle getInlineStyle() {
        return this.inlineStyle;
    }

    public void setAttributesStyle (jpuppeteer.cdp.client.entity.css.CSSStyle attributesStyle) {
        this.attributesStyle = attributesStyle;
    }

    public jpuppeteer.cdp.client.entity.css.CSSStyle getAttributesStyle() {
        return this.attributesStyle;
    }

    public void setMatchedCSSRules (java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> matchedCSSRules) {
        this.matchedCSSRules = matchedCSSRules;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.RuleMatch> getMatchedCSSRules() {
        return this.matchedCSSRules;
    }

    public void setPseudoElements (java.util.List<jpuppeteer.cdp.client.entity.css.PseudoElementMatches> pseudoElements) {
        this.pseudoElements = pseudoElements;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.PseudoElementMatches> getPseudoElements() {
        return this.pseudoElements;
    }

    public void setInherited (java.util.List<jpuppeteer.cdp.client.entity.css.InheritedStyleEntry> inherited) {
        this.inherited = inherited;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.InheritedStyleEntry> getInherited() {
        return this.inherited;
    }

    public void setCssKeyframesRules (java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframesRule> cssKeyframesRules) {
        this.cssKeyframesRules = cssKeyframesRules;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.css.CSSKeyframesRule> getCssKeyframesRules() {
        return this.cssKeyframesRules;
    }

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