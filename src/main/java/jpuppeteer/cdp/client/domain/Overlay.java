package jpuppeteer.cdp.client.domain;

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
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Overlay.disable", null);
    }


    /**
    * Enables domain notifications.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Overlay.enable", null);
    }


    /**
    * For testing.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.overlay.GetHighlightObjectForTestResponse> getHighlightObjectForTest(jpuppeteer.cdp.client.entity.overlay.GetHighlightObjectForTestRequest request) {
        return session.send("Overlay.getHighlightObjectForTest", request, jpuppeteer.cdp.client.entity.overlay.GetHighlightObjectForTestResponse.class);
    }


    /**
    * Hides any highlight.
    */
    public io.netty.util.concurrent.Future hideHighlight() {
        return session.send("Overlay.hideHighlight", null);
    }


    /**
    * Highlights owner element of the frame with given id.
    */
    public io.netty.util.concurrent.Future highlightFrame(jpuppeteer.cdp.client.entity.overlay.HighlightFrameRequest request) {
        return session.send("Overlay.highlightFrame", request);
    }


    /**
    * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or objectId must be specified.
    */
    public io.netty.util.concurrent.Future highlightNode(jpuppeteer.cdp.client.entity.overlay.HighlightNodeRequest request) {
        return session.send("Overlay.highlightNode", request);
    }


    /**
    * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
    */
    public io.netty.util.concurrent.Future highlightQuad(jpuppeteer.cdp.client.entity.overlay.HighlightQuadRequest request) {
        return session.send("Overlay.highlightQuad", request);
    }


    /**
    * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
    */
    public io.netty.util.concurrent.Future highlightRect(jpuppeteer.cdp.client.entity.overlay.HighlightRectRequest request) {
        return session.send("Overlay.highlightRect", request);
    }


    /**
    * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted. Backend then generates 'inspectNodeRequested' event upon element selection.
    */
    public io.netty.util.concurrent.Future setInspectMode(jpuppeteer.cdp.client.entity.overlay.SetInspectModeRequest request) {
        return session.send("Overlay.setInspectMode", request);
    }


    /**
    * Highlights owner element of all frames detected to be ads.
    */
    public io.netty.util.concurrent.Future setShowAdHighlights(jpuppeteer.cdp.client.entity.overlay.SetShowAdHighlightsRequest request) {
        return session.send("Overlay.setShowAdHighlights", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future setPausedInDebuggerMessage(jpuppeteer.cdp.client.entity.overlay.SetPausedInDebuggerMessageRequest request) {
        return session.send("Overlay.setPausedInDebuggerMessage", request);
    }


    /**
    * Requests that backend shows debug borders on layers
    */
    public io.netty.util.concurrent.Future setShowDebugBorders(jpuppeteer.cdp.client.entity.overlay.SetShowDebugBordersRequest request) {
        return session.send("Overlay.setShowDebugBorders", request);
    }


    /**
    * Requests that backend shows the FPS counter
    */
    public io.netty.util.concurrent.Future setShowFPSCounter(jpuppeteer.cdp.client.entity.overlay.SetShowFPSCounterRequest request) {
        return session.send("Overlay.setShowFPSCounter", request);
    }


    /**
    * Requests that backend shows paint rectangles
    */
    public io.netty.util.concurrent.Future setShowPaintRects(jpuppeteer.cdp.client.entity.overlay.SetShowPaintRectsRequest request) {
        return session.send("Overlay.setShowPaintRects", request);
    }


    /**
    * Requests that backend shows layout shift regions
    */
    public io.netty.util.concurrent.Future setShowLayoutShiftRegions(jpuppeteer.cdp.client.entity.overlay.SetShowLayoutShiftRegionsRequest request) {
        return session.send("Overlay.setShowLayoutShiftRegions", request);
    }


    /**
    * Requests that backend shows scroll bottleneck rects
    */
    public io.netty.util.concurrent.Future setShowScrollBottleneckRects(jpuppeteer.cdp.client.entity.overlay.SetShowScrollBottleneckRectsRequest request) {
        return session.send("Overlay.setShowScrollBottleneckRects", request);
    }


    /**
    * Requests that backend shows hit-test borders on layers
    */
    public io.netty.util.concurrent.Future setShowHitTestBorders(jpuppeteer.cdp.client.entity.overlay.SetShowHitTestBordersRequest request) {
        return session.send("Overlay.setShowHitTestBorders", request);
    }


    /**
    * Paints viewport size upon main frame resize.
    */
    public io.netty.util.concurrent.Future setShowViewportSizeOnResize(jpuppeteer.cdp.client.entity.overlay.SetShowViewportSizeOnResizeRequest request) {
        return session.send("Overlay.setShowViewportSizeOnResize", request);
    }

}