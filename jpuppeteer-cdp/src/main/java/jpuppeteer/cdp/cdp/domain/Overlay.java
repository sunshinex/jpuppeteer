package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class Overlay {

    private jpuppeteer.cdp.CDPSession session;

    public Overlay(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Disables domain notifications.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("Overlay.disable", null, timeout);
    }


    /**
    * Enables domain notifications.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("Overlay.enable", null, timeout);
    }


    /**
    * For testing.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.overlay.GetHighlightObjectForTestResponse getHighlightObjectForTest(jpuppeteer.cdp.cdp.entity.overlay.GetHighlightObjectForTestRequest request, int timeout) throws Exception {
        return session.send("Overlay.getHighlightObjectForTest", request, jpuppeteer.cdp.cdp.entity.overlay.GetHighlightObjectForTestResponse.class, timeout);
    }


    /**
    * Hides any highlight.
    * experimental
    */
    public void hideHighlight(int timeout) throws Exception {
        session.send("Overlay.hideHighlight", null, timeout);
    }


    /**
    * Highlights owner element of the frame with given id.
    * experimental
    */
    public void highlightFrame(jpuppeteer.cdp.cdp.entity.overlay.HighlightFrameRequest request, int timeout) throws Exception {
        session.send("Overlay.highlightFrame", request, timeout);
    }


    /**
    * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or objectId must be specified.
    * experimental
    */
    public void highlightNode(jpuppeteer.cdp.cdp.entity.overlay.HighlightNodeRequest request, int timeout) throws Exception {
        session.send("Overlay.highlightNode", request, timeout);
    }


    /**
    * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
    * experimental
    */
    public void highlightQuad(jpuppeteer.cdp.cdp.entity.overlay.HighlightQuadRequest request, int timeout) throws Exception {
        session.send("Overlay.highlightQuad", request, timeout);
    }


    /**
    * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
    * experimental
    */
    public void highlightRect(jpuppeteer.cdp.cdp.entity.overlay.HighlightRectRequest request, int timeout) throws Exception {
        session.send("Overlay.highlightRect", request, timeout);
    }


    /**
    * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted. Backend then generates 'inspectNodeRequested' event upon element selection.
    * experimental
    */
    public void setInspectMode(jpuppeteer.cdp.cdp.entity.overlay.SetInspectModeRequest request, int timeout) throws Exception {
        session.send("Overlay.setInspectMode", request, timeout);
    }


    /**
    * Highlights owner element of all frames detected to be ads.
    * experimental
    */
    public void setShowAdHighlights(jpuppeteer.cdp.cdp.entity.overlay.SetShowAdHighlightsRequest request, int timeout) throws Exception {
        session.send("Overlay.setShowAdHighlights", request, timeout);
    }


    /**
    * experimental
    */
    public void setPausedInDebuggerMessage(jpuppeteer.cdp.cdp.entity.overlay.SetPausedInDebuggerMessageRequest request, int timeout) throws Exception {
        session.send("Overlay.setPausedInDebuggerMessage", request, timeout);
    }


    /**
    * Requests that backend shows debug borders on layers
    * experimental
    */
    public void setShowDebugBorders(jpuppeteer.cdp.cdp.entity.overlay.SetShowDebugBordersRequest request, int timeout) throws Exception {
        session.send("Overlay.setShowDebugBorders", request, timeout);
    }


    /**
    * Requests that backend shows the FPS counter
    * experimental
    */
    public void setShowFPSCounter(jpuppeteer.cdp.cdp.entity.overlay.SetShowFPSCounterRequest request, int timeout) throws Exception {
        session.send("Overlay.setShowFPSCounter", request, timeout);
    }


    /**
    * Requests that backend shows paint rectangles
    * experimental
    */
    public void setShowPaintRects(jpuppeteer.cdp.cdp.entity.overlay.SetShowPaintRectsRequest request, int timeout) throws Exception {
        session.send("Overlay.setShowPaintRects", request, timeout);
    }


    /**
    * Requests that backend shows layout shift regions
    * experimental
    */
    public void setShowLayoutShiftRegions(jpuppeteer.cdp.cdp.entity.overlay.SetShowLayoutShiftRegionsRequest request, int timeout) throws Exception {
        session.send("Overlay.setShowLayoutShiftRegions", request, timeout);
    }


    /**
    * Requests that backend shows scroll bottleneck rects
    * experimental
    */
    public void setShowScrollBottleneckRects(jpuppeteer.cdp.cdp.entity.overlay.SetShowScrollBottleneckRectsRequest request, int timeout) throws Exception {
        session.send("Overlay.setShowScrollBottleneckRects", request, timeout);
    }


    /**
    * Requests that backend shows hit-test borders on layers
    * experimental
    */
    public void setShowHitTestBorders(jpuppeteer.cdp.cdp.entity.overlay.SetShowHitTestBordersRequest request, int timeout) throws Exception {
        session.send("Overlay.setShowHitTestBorders", request, timeout);
    }


    /**
    * Paints viewport size upon main frame resize.
    * experimental
    */
    public void setShowViewportSizeOnResize(jpuppeteer.cdp.cdp.entity.overlay.SetShowViewportSizeOnResizeRequest request, int timeout) throws Exception {
        session.send("Overlay.setShowViewportSizeOnResize", request, timeout);
    }

}