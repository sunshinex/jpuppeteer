package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetLayoutMetricsResponse {

    /**
    * Deprecated metrics relating to the layout viewport. Can be in DP or in CSS pixels depending on the `enable-use-zoom-for-dsf` flag. Use `cssLayoutViewport` instead.
    */
    private jpuppeteer.cdp.client.entity.page.LayoutViewport layoutViewport;

    /**
    * Deprecated metrics relating to the visual viewport. Can be in DP or in CSS pixels depending on the `enable-use-zoom-for-dsf` flag. Use `cssVisualViewport` instead.
    */
    private jpuppeteer.cdp.client.entity.page.VisualViewport visualViewport;

    /**
    * Deprecated size of scrollable area. Can be in DP or in CSS pixels depending on the `enable-use-zoom-for-dsf` flag. Use `cssContentSize` instead.
    */
    private jpuppeteer.cdp.client.entity.dom.Rect contentSize;

    /**
    * Metrics relating to the layout viewport in CSS pixels.
    */
    private jpuppeteer.cdp.client.entity.page.LayoutViewport cssLayoutViewport;

    /**
    * Metrics relating to the visual viewport in CSS pixels.
    */
    private jpuppeteer.cdp.client.entity.page.VisualViewport cssVisualViewport;

    /**
    * Size of scrollable area in CSS pixels.
    */
    private jpuppeteer.cdp.client.entity.dom.Rect cssContentSize;

    public void setLayoutViewport (jpuppeteer.cdp.client.entity.page.LayoutViewport layoutViewport) {
        this.layoutViewport = layoutViewport;
    }

    public jpuppeteer.cdp.client.entity.page.LayoutViewport getLayoutViewport() {
        return this.layoutViewport;
    }

    public void setVisualViewport (jpuppeteer.cdp.client.entity.page.VisualViewport visualViewport) {
        this.visualViewport = visualViewport;
    }

    public jpuppeteer.cdp.client.entity.page.VisualViewport getVisualViewport() {
        return this.visualViewport;
    }

    public void setContentSize (jpuppeteer.cdp.client.entity.dom.Rect contentSize) {
        this.contentSize = contentSize;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getContentSize() {
        return this.contentSize;
    }

    public void setCssLayoutViewport (jpuppeteer.cdp.client.entity.page.LayoutViewport cssLayoutViewport) {
        this.cssLayoutViewport = cssLayoutViewport;
    }

    public jpuppeteer.cdp.client.entity.page.LayoutViewport getCssLayoutViewport() {
        return this.cssLayoutViewport;
    }

    public void setCssVisualViewport (jpuppeteer.cdp.client.entity.page.VisualViewport cssVisualViewport) {
        this.cssVisualViewport = cssVisualViewport;
    }

    public jpuppeteer.cdp.client.entity.page.VisualViewport getCssVisualViewport() {
        return this.cssVisualViewport;
    }

    public void setCssContentSize (jpuppeteer.cdp.client.entity.dom.Rect cssContentSize) {
        this.cssContentSize = cssContentSize;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getCssContentSize() {
        return this.cssContentSize;
    }

    public GetLayoutMetricsResponse(jpuppeteer.cdp.client.entity.page.LayoutViewport layoutViewport, jpuppeteer.cdp.client.entity.page.VisualViewport visualViewport, jpuppeteer.cdp.client.entity.dom.Rect contentSize, jpuppeteer.cdp.client.entity.page.LayoutViewport cssLayoutViewport, jpuppeteer.cdp.client.entity.page.VisualViewport cssVisualViewport, jpuppeteer.cdp.client.entity.dom.Rect cssContentSize) {
        this.layoutViewport = layoutViewport;
        this.visualViewport = visualViewport;
        this.contentSize = contentSize;
        this.cssLayoutViewport = cssLayoutViewport;
        this.cssVisualViewport = cssVisualViewport;
        this.cssContentSize = cssContentSize;
    }

    public GetLayoutMetricsResponse() {
    }

}