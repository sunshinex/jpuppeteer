package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.AddRuleResponse addRule(jpuppeteer.cdp.cdp.entity.css.AddRuleRequest request, int timeout) throws Exception {
        return session.send("CSS.addRule", request, jpuppeteer.cdp.cdp.entity.css.AddRuleResponse.class, timeout);
    }


    /**
    * Returns all class names from specified stylesheet.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.CollectClassNamesResponse collectClassNames(jpuppeteer.cdp.cdp.entity.css.CollectClassNamesRequest request, int timeout) throws Exception {
        return session.send("CSS.collectClassNames", request, jpuppeteer.cdp.cdp.entity.css.CollectClassNamesResponse.class, timeout);
    }


    /**
    * Creates a new special "via-inspector" stylesheet in the frame with given `frameId`.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.CreateStyleSheetResponse createStyleSheet(jpuppeteer.cdp.cdp.entity.css.CreateStyleSheetRequest request, int timeout) throws Exception {
        return session.send("CSS.createStyleSheet", request, jpuppeteer.cdp.cdp.entity.css.CreateStyleSheetResponse.class, timeout);
    }


    /**
    * Disables the CSS agent for the given page.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("CSS.disable", null, timeout);
    }


    /**
    * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been enabled until the result of this command is received.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("CSS.enable", null, timeout);
    }


    /**
    * Ensures that the given node will have specified pseudo-classes whenever its style is computed by the browser.
    * experimental
    */
    public void forcePseudoState(jpuppeteer.cdp.cdp.entity.css.ForcePseudoStateRequest request, int timeout) throws Exception {
        session.send("CSS.forcePseudoState", request, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.GetBackgroundColorsResponse getBackgroundColors(jpuppeteer.cdp.cdp.entity.css.GetBackgroundColorsRequest request, int timeout) throws Exception {
        return session.send("CSS.getBackgroundColors", request, jpuppeteer.cdp.cdp.entity.css.GetBackgroundColorsResponse.class, timeout);
    }


    /**
    * Returns the computed style for a DOM node identified by `nodeId`.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.GetComputedStyleForNodeResponse getComputedStyleForNode(jpuppeteer.cdp.cdp.entity.css.GetComputedStyleForNodeRequest request, int timeout) throws Exception {
        return session.send("CSS.getComputedStyleForNode", request, jpuppeteer.cdp.cdp.entity.css.GetComputedStyleForNodeResponse.class, timeout);
    }


    /**
    * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM attributes) for a DOM node identified by `nodeId`.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.GetInlineStylesForNodeResponse getInlineStylesForNode(jpuppeteer.cdp.cdp.entity.css.GetInlineStylesForNodeRequest request, int timeout) throws Exception {
        return session.send("CSS.getInlineStylesForNode", request, jpuppeteer.cdp.cdp.entity.css.GetInlineStylesForNodeResponse.class, timeout);
    }


    /**
    * Returns requested styles for a DOM node identified by `nodeId`.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.GetMatchedStylesForNodeResponse getMatchedStylesForNode(jpuppeteer.cdp.cdp.entity.css.GetMatchedStylesForNodeRequest request, int timeout) throws Exception {
        return session.send("CSS.getMatchedStylesForNode", request, jpuppeteer.cdp.cdp.entity.css.GetMatchedStylesForNodeResponse.class, timeout);
    }


    /**
    * Returns all media queries parsed by the rendering engine.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.GetMediaQueriesResponse getMediaQueries(int timeout) throws Exception {
        return session.send("CSS.getMediaQueries", null, jpuppeteer.cdp.cdp.entity.css.GetMediaQueriesResponse.class, timeout);
    }


    /**
    * Requests information about platform fonts which we used to render child TextNodes in the given node.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.GetPlatformFontsForNodeResponse getPlatformFontsForNode(jpuppeteer.cdp.cdp.entity.css.GetPlatformFontsForNodeRequest request, int timeout) throws Exception {
        return session.send("CSS.getPlatformFontsForNode", request, jpuppeteer.cdp.cdp.entity.css.GetPlatformFontsForNodeResponse.class, timeout);
    }


    /**
    * Returns the current textual content for a stylesheet.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.GetStyleSheetTextResponse getStyleSheetText(jpuppeteer.cdp.cdp.entity.css.GetStyleSheetTextRequest request, int timeout) throws Exception {
        return session.send("CSS.getStyleSheetText", request, jpuppeteer.cdp.cdp.entity.css.GetStyleSheetTextResponse.class, timeout);
    }


    /**
    * Find a rule with the given active property for the given node and set the new value for this property
    * experimental
    */
    public void setEffectivePropertyValueForNode(jpuppeteer.cdp.cdp.entity.css.SetEffectivePropertyValueForNodeRequest request, int timeout) throws Exception {
        session.send("CSS.setEffectivePropertyValueForNode", request, timeout);
    }


    /**
    * Modifies the keyframe rule key text.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.SetKeyframeKeyResponse setKeyframeKey(jpuppeteer.cdp.cdp.entity.css.SetKeyframeKeyRequest request, int timeout) throws Exception {
        return session.send("CSS.setKeyframeKey", request, jpuppeteer.cdp.cdp.entity.css.SetKeyframeKeyResponse.class, timeout);
    }


    /**
    * Modifies the rule selector.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.SetMediaTextResponse setMediaText(jpuppeteer.cdp.cdp.entity.css.SetMediaTextRequest request, int timeout) throws Exception {
        return session.send("CSS.setMediaText", request, jpuppeteer.cdp.cdp.entity.css.SetMediaTextResponse.class, timeout);
    }


    /**
    * Modifies the rule selector.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.SetRuleSelectorResponse setRuleSelector(jpuppeteer.cdp.cdp.entity.css.SetRuleSelectorRequest request, int timeout) throws Exception {
        return session.send("CSS.setRuleSelector", request, jpuppeteer.cdp.cdp.entity.css.SetRuleSelectorResponse.class, timeout);
    }


    /**
    * Sets the new stylesheet text.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.SetStyleSheetTextResponse setStyleSheetText(jpuppeteer.cdp.cdp.entity.css.SetStyleSheetTextRequest request, int timeout) throws Exception {
        return session.send("CSS.setStyleSheetText", request, jpuppeteer.cdp.cdp.entity.css.SetStyleSheetTextResponse.class, timeout);
    }


    /**
    * Applies specified style edits one after another in the given order.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.SetStyleTextsResponse setStyleTexts(jpuppeteer.cdp.cdp.entity.css.SetStyleTextsRequest request, int timeout) throws Exception {
        return session.send("CSS.setStyleTexts", request, jpuppeteer.cdp.cdp.entity.css.SetStyleTextsResponse.class, timeout);
    }


    /**
    * Enables the selector recording.
    * experimental
    */
    public void startRuleUsageTracking(int timeout) throws Exception {
        session.send("CSS.startRuleUsageTracking", null, timeout);
    }


    /**
    * Stop tracking rule usage and return the list of rules that were used since last call to `takeCoverageDelta` (or since start of coverage instrumentation)
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.StopRuleUsageTrackingResponse stopRuleUsageTracking(int timeout) throws Exception {
        return session.send("CSS.stopRuleUsageTracking", null, jpuppeteer.cdp.cdp.entity.css.StopRuleUsageTrackingResponse.class, timeout);
    }


    /**
    * Obtain list of rules that became used since last call to this method (or since start of coverage instrumentation)
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.css.TakeCoverageDeltaResponse takeCoverageDelta(int timeout) throws Exception {
        return session.send("CSS.takeCoverageDelta", null, jpuppeteer.cdp.cdp.entity.css.TakeCoverageDeltaResponse.class, timeout);
    }

}