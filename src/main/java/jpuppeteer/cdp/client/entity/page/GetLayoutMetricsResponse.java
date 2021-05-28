package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetLayoutMetricsResponse {

    /**
    * Deprecated metrics relating to the layout viewport. Can be in DP or in CSS pixels depending on the `enable-use-zoom-for-dsf` flag. Use `cssLayoutViewport` instead.
    */
    public final jpuppeteer.cdp.client.entity.page.LayoutViewport layoutViewport;

    /**
    * Deprecated metrics relating to the visual viewport. Can be in DP or in CSS pixels depending on the `enable-use-zoom-for-dsf` flag. Use `cssVisualViewport` instead.
    */
    public final jpuppeteer.cdp.client.entity.page.VisualViewport visualViewport;

    /**
    * Deprecated size of scrollable area. Can be in DP or in CSS pixels depending on the `enable-use-zoom-for-dsf` flag. Use `cssContentSize` instead.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect contentSize;

    /**
    * Metrics relating to the layout viewport in CSS pixels.
    */
    public final jpuppeteer.cdp.client.entity.page.LayoutViewport cssLayoutViewport;

    /**
    * Metrics relating to the visual viewport in CSS pixels.
    */
    public final jpuppeteer.cdp.client.entity.page.VisualViewport cssVisualViewport;

    /**
    * Size of scrollable area in CSS pixels.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect cssContentSize;

    public GetLayoutMetricsResponse(jpuppeteer.cdp.client.entity.page.LayoutViewport layoutViewport, jpuppeteer.cdp.client.entity.page.VisualViewport visualViewport, jpuppeteer.cdp.client.entity.dom.Rect contentSize, jpuppeteer.cdp.client.entity.page.LayoutViewport cssLayoutViewport, jpuppeteer.cdp.client.entity.page.VisualViewport cssVisualViewport, jpuppeteer.cdp.client.entity.dom.Rect cssContentSize) {
        this.layoutViewport = layoutViewport;
        this.visualViewport = visualViewport;
        this.contentSize = contentSize;
        this.cssLayoutViewport = cssLayoutViewport;
        this.cssVisualViewport = cssVisualViewport;
        this.cssContentSize = cssContentSize;
    }

}