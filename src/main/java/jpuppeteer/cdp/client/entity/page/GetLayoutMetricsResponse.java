package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetLayoutMetricsResponse {

    /**
    * Metrics relating to the layout viewport.
    */
    public final jpuppeteer.cdp.client.entity.page.LayoutViewport layoutViewport;

    /**
    * Metrics relating to the visual viewport.
    */
    public final jpuppeteer.cdp.client.entity.page.VisualViewport visualViewport;

    /**
    * Size of scrollable area.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect contentSize;

    public GetLayoutMetricsResponse(jpuppeteer.cdp.client.entity.page.LayoutViewport layoutViewport, jpuppeteer.cdp.client.entity.page.VisualViewport visualViewport, jpuppeteer.cdp.client.entity.dom.Rect contentSize) {
        this.layoutViewport = layoutViewport;
        this.visualViewport = visualViewport;
        this.contentSize = contentSize;
    }

}