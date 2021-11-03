package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Overlay {

    private jpuppeteer.cdp.CDPConnection connection;

    public Overlay(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disables domain notifications.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Overlay.disable", null);
    }


    /**
    * Enables domain notifications.
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("Overlay.enable", null);
    }


    /**
    * For testing.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.overlay.GetHighlightObjectForTestResponse> getHighlightObjectForTest(jpuppeteer.cdp.client.entity.overlay.GetHighlightObjectForTestRequest request) {
        return connection.send("Overlay.getHighlightObjectForTest", request, jpuppeteer.cdp.client.entity.overlay.GetHighlightObjectForTestResponse.class);
    }


    /**
    * For Persistent Grid testing.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.overlay.GetGridHighlightObjectsForTestResponse> getGridHighlightObjectsForTest(jpuppeteer.cdp.client.entity.overlay.GetGridHighlightObjectsForTestRequest request) {
        return connection.send("Overlay.getGridHighlightObjectsForTest", request, jpuppeteer.cdp.client.entity.overlay.GetGridHighlightObjectsForTestResponse.class);
    }


    /**
    * For Source Order Viewer testing.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.overlay.GetSourceOrderHighlightObjectForTestResponse> getSourceOrderHighlightObjectForTest(jpuppeteer.cdp.client.entity.overlay.GetSourceOrderHighlightObjectForTestRequest request) {
        return connection.send("Overlay.getSourceOrderHighlightObjectForTest", request, jpuppeteer.cdp.client.entity.overlay.GetSourceOrderHighlightObjectForTestResponse.class);
    }


    /**
    * Hides any highlight.
    */
    public io.netty.util.concurrent.Future hideHighlight() {
        return connection.send("Overlay.hideHighlight", null);
    }


    /**
    * Highlights owner element of the frame with given id.
    */
    public io.netty.util.concurrent.Future highlightFrame(jpuppeteer.cdp.client.entity.overlay.HighlightFrameRequest request) {
        return connection.send("Overlay.highlightFrame", request);
    }


    /**
    * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or objectId must be specified.
    */
    public io.netty.util.concurrent.Future highlightNode(jpuppeteer.cdp.client.entity.overlay.HighlightNodeRequest request) {
        return connection.send("Overlay.highlightNode", request);
    }


    /**
    * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
    */
    public io.netty.util.concurrent.Future highlightQuad(jpuppeteer.cdp.client.entity.overlay.HighlightQuadRequest request) {
        return connection.send("Overlay.highlightQuad", request);
    }


    /**
    * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
    */
    public io.netty.util.concurrent.Future highlightRect(jpuppeteer.cdp.client.entity.overlay.HighlightRectRequest request) {
        return connection.send("Overlay.highlightRect", request);
    }


    /**
    * Highlights the source order of the children of the DOM node with given id or with the given JavaScript object wrapper. Either nodeId or objectId must be specified.
    */
    public io.netty.util.concurrent.Future highlightSourceOrder(jpuppeteer.cdp.client.entity.overlay.HighlightSourceOrderRequest request) {
        return connection.send("Overlay.highlightSourceOrder", request);
    }


    /**
    * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted. Backend then generates 'inspectNodeRequested' event upon element selection.
    */
    public io.netty.util.concurrent.Future setInspectMode(jpuppeteer.cdp.client.entity.overlay.SetInspectModeRequest request) {
        return connection.send("Overlay.setInspectMode", request);
    }


    /**
    * Highlights owner element of all frames detected to be ads.
    */
    public io.netty.util.concurrent.Future setShowAdHighlights(jpuppeteer.cdp.client.entity.overlay.SetShowAdHighlightsRequest request) {
        return connection.send("Overlay.setShowAdHighlights", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future setPausedInDebuggerMessage(jpuppeteer.cdp.client.entity.overlay.SetPausedInDebuggerMessageRequest request) {
        return connection.send("Overlay.setPausedInDebuggerMessage", request);
    }


    /**
    * Requests that backend shows debug borders on layers
    */
    public io.netty.util.concurrent.Future setShowDebugBorders(jpuppeteer.cdp.client.entity.overlay.SetShowDebugBordersRequest request) {
        return connection.send("Overlay.setShowDebugBorders", request);
    }


    /**
    * Requests that backend shows the FPS counter
    */
    public io.netty.util.concurrent.Future setShowFPSCounter(jpuppeteer.cdp.client.entity.overlay.SetShowFPSCounterRequest request) {
        return connection.send("Overlay.setShowFPSCounter", request);
    }


    /**
    * Highlight multiple elements with the CSS Grid overlay.
    */
    public io.netty.util.concurrent.Future setShowGridOverlays(jpuppeteer.cdp.client.entity.overlay.SetShowGridOverlaysRequest request) {
        return connection.send("Overlay.setShowGridOverlays", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future setShowFlexOverlays(jpuppeteer.cdp.client.entity.overlay.SetShowFlexOverlaysRequest request) {
        return connection.send("Overlay.setShowFlexOverlays", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future setShowScrollSnapOverlays(jpuppeteer.cdp.client.entity.overlay.SetShowScrollSnapOverlaysRequest request) {
        return connection.send("Overlay.setShowScrollSnapOverlays", request);
    }


    /**
    * Requests that backend shows paint rectangles
    */
    public io.netty.util.concurrent.Future setShowPaintRects(jpuppeteer.cdp.client.entity.overlay.SetShowPaintRectsRequest request) {
        return connection.send("Overlay.setShowPaintRects", request);
    }


    /**
    * Requests that backend shows layout shift regions
    */
    public io.netty.util.concurrent.Future setShowLayoutShiftRegions(jpuppeteer.cdp.client.entity.overlay.SetShowLayoutShiftRegionsRequest request) {
        return connection.send("Overlay.setShowLayoutShiftRegions", request);
    }


    /**
    * Requests that backend shows scroll bottleneck rects
    */
    public io.netty.util.concurrent.Future setShowScrollBottleneckRects(jpuppeteer.cdp.client.entity.overlay.SetShowScrollBottleneckRectsRequest request) {
        return connection.send("Overlay.setShowScrollBottleneckRects", request);
    }


    /**
    * Requests that backend shows hit-test borders on layers
    */
    public io.netty.util.concurrent.Future setShowHitTestBorders(jpuppeteer.cdp.client.entity.overlay.SetShowHitTestBordersRequest request) {
        return connection.send("Overlay.setShowHitTestBorders", request);
    }


    /**
    * Request that backend shows an overlay with web vital metrics.
    */
    public io.netty.util.concurrent.Future setShowWebVitals(jpuppeteer.cdp.client.entity.overlay.SetShowWebVitalsRequest request) {
        return connection.send("Overlay.setShowWebVitals", request);
    }


    /**
    * Paints viewport size upon main frame resize.
    */
    public io.netty.util.concurrent.Future setShowViewportSizeOnResize(jpuppeteer.cdp.client.entity.overlay.SetShowViewportSizeOnResizeRequest request) {
        return connection.send("Overlay.setShowViewportSizeOnResize", request);
    }


    /**
    * Add a dual screen device hinge
    */
    public io.netty.util.concurrent.Future setShowHinge(jpuppeteer.cdp.client.entity.overlay.SetShowHingeRequest request) {
        return connection.send("Overlay.setShowHinge", request);
    }

}