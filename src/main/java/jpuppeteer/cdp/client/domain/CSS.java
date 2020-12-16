package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class CSS {

    private jpuppeteer.cdp.CDPSession session;

    public CSS(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Inserts a new rule with the given `ruleText` in a stylesheet with given `styleSheetId`, at the position specified by `location`.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.AddRuleResponse> addRule(jpuppeteer.cdp.client.entity.css.AddRuleRequest request) {
        return session.send("CSS.addRule", request, jpuppeteer.cdp.client.entity.css.AddRuleResponse.class);
    }


    /**
    * Returns all class names from specified stylesheet.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.CollectClassNamesResponse> collectClassNames(jpuppeteer.cdp.client.entity.css.CollectClassNamesRequest request) {
        return session.send("CSS.collectClassNames", request, jpuppeteer.cdp.client.entity.css.CollectClassNamesResponse.class);
    }


    /**
    * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.CreateStyleSheetResponse> createStyleSheet(jpuppeteer.cdp.client.entity.css.CreateStyleSheetRequest request) {
        return session.send("CSS.createStyleSheet", request, jpuppeteer.cdp.client.entity.css.CreateStyleSheetResponse.class);
    }


    /**
    * Disables the CSS agent for the given page.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("CSS.disable", null);
    }


    /**
    * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been enabled until the result of this command is received.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("CSS.enable", null);
    }


    /**
    * Ensures that the given node will have specified pseudo-classes whenever its style is computed by the browser.
    */
    public io.netty.util.concurrent.Future forcePseudoState(jpuppeteer.cdp.client.entity.css.ForcePseudoStateRequest request) {
        return session.send("CSS.forcePseudoState", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.GetBackgroundColorsResponse> getBackgroundColors(jpuppeteer.cdp.client.entity.css.GetBackgroundColorsRequest request) {
        return session.send("CSS.getBackgroundColors", request, jpuppeteer.cdp.client.entity.css.GetBackgroundColorsResponse.class);
    }


    /**
    * Returns the computed style for a DOM node identified by `nodeId`.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.GetComputedStyleForNodeResponse> getComputedStyleForNode(jpuppeteer.cdp.client.entity.css.GetComputedStyleForNodeRequest request) {
        return session.send("CSS.getComputedStyleForNode", request, jpuppeteer.cdp.client.entity.css.GetComputedStyleForNodeResponse.class);
    }


    /**
    * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM attributes) for a DOM node identified by `nodeId`.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.GetInlineStylesForNodeResponse> getInlineStylesForNode(jpuppeteer.cdp.client.entity.css.GetInlineStylesForNodeRequest request) {
        return session.send("CSS.getInlineStylesForNode", request, jpuppeteer.cdp.client.entity.css.GetInlineStylesForNodeResponse.class);
    }


    /**
    * Returns requested styles for a DOM node identified by `nodeId`.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.GetMatchedStylesForNodeResponse> getMatchedStylesForNode(jpuppeteer.cdp.client.entity.css.GetMatchedStylesForNodeRequest request) {
        return session.send("CSS.getMatchedStylesForNode", request, jpuppeteer.cdp.client.entity.css.GetMatchedStylesForNodeResponse.class);
    }


    /**
    * Returns all media queries parsed by the rendering engine.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.GetMediaQueriesResponse> getMediaQueries() {
        return session.send("CSS.getMediaQueries", null, jpuppeteer.cdp.client.entity.css.GetMediaQueriesResponse.class);
    }


    /**
    * Requests information about platform fonts which we used to render child TextNodes in the given node.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.GetPlatformFontsForNodeResponse> getPlatformFontsForNode(jpuppeteer.cdp.client.entity.css.GetPlatformFontsForNodeRequest request) {
        return session.send("CSS.getPlatformFontsForNode", request, jpuppeteer.cdp.client.entity.css.GetPlatformFontsForNodeResponse.class);
    }


    /**
    * Returns the current textual content for a stylesheet.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.GetStyleSheetTextResponse> getStyleSheetText(jpuppeteer.cdp.client.entity.css.GetStyleSheetTextRequest request) {
        return session.send("CSS.getStyleSheetText", request, jpuppeteer.cdp.client.entity.css.GetStyleSheetTextResponse.class);
    }


    /**
    * Find a rule with the given active property for the given node and set the new value for this property
    */
    public io.netty.util.concurrent.Future setEffectivePropertyValueForNode(jpuppeteer.cdp.client.entity.css.SetEffectivePropertyValueForNodeRequest request) {
        return session.send("CSS.setEffectivePropertyValueForNode", request);
    }


    /**
    * Modifies the keyframe rule key text.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.SetKeyframeKeyResponse> setKeyframeKey(jpuppeteer.cdp.client.entity.css.SetKeyframeKeyRequest request) {
        return session.send("CSS.setKeyframeKey", request, jpuppeteer.cdp.client.entity.css.SetKeyframeKeyResponse.class);
    }


    /**
    * Modifies the rule selector.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.SetMediaTextResponse> setMediaText(jpuppeteer.cdp.client.entity.css.SetMediaTextRequest request) {
        return session.send("CSS.setMediaText", request, jpuppeteer.cdp.client.entity.css.SetMediaTextResponse.class);
    }


    /**
    * Modifies the rule selector.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.SetRuleSelectorResponse> setRuleSelector(jpuppeteer.cdp.client.entity.css.SetRuleSelectorRequest request) {
        return session.send("CSS.setRuleSelector", request, jpuppeteer.cdp.client.entity.css.SetRuleSelectorResponse.class);
    }


    /**
    * Sets the new stylesheet text.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.SetStyleSheetTextResponse> setStyleSheetText(jpuppeteer.cdp.client.entity.css.SetStyleSheetTextRequest request) {
        return session.send("CSS.setStyleSheetText", request, jpuppeteer.cdp.client.entity.css.SetStyleSheetTextResponse.class);
    }


    /**
    * Applies specified style edits one after another in the given order.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.SetStyleTextsResponse> setStyleTexts(jpuppeteer.cdp.client.entity.css.SetStyleTextsRequest request) {
        return session.send("CSS.setStyleTexts", request, jpuppeteer.cdp.client.entity.css.SetStyleTextsResponse.class);
    }


    /**
    * Enables the selector recording.
    */
    public io.netty.util.concurrent.Future startRuleUsageTracking() {
        return session.send("CSS.startRuleUsageTracking", null);
    }


    /**
    * Stop tracking rule usage and return the list of rules that were used since last call to `takeCoverageDelta` (or since start of coverage instrumentation)
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.StopRuleUsageTrackingResponse> stopRuleUsageTracking() {
        return session.send("CSS.stopRuleUsageTracking", null, jpuppeteer.cdp.client.entity.css.StopRuleUsageTrackingResponse.class);
    }


    /**
    * Obtain list of rules that became used since last call to this method (or since start of coverage instrumentation)
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.css.TakeCoverageDeltaResponse> takeCoverageDelta() {
        return session.send("CSS.takeCoverageDelta", null, jpuppeteer.cdp.client.entity.css.TakeCoverageDeltaResponse.class);
    }

}