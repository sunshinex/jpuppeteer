package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class ScrollSnapContainerHighlightConfig {

    /**
    * The style of the snapport border (default: transparent)
    */
    private jpuppeteer.cdp.client.entity.overlay.LineStyle snapportBorder;

    /**
    * The style of the snap area border (default: transparent)
    */
    private jpuppeteer.cdp.client.entity.overlay.LineStyle snapAreaBorder;

    /**
    * The margin highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA scrollMarginColor;

    /**
    * The padding highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA scrollPaddingColor;

    public void setSnapportBorder (jpuppeteer.cdp.client.entity.overlay.LineStyle snapportBorder) {
        this.snapportBorder = snapportBorder;
    }

    public jpuppeteer.cdp.client.entity.overlay.LineStyle getSnapportBorder() {
        return this.snapportBorder;
    }

    public void setSnapAreaBorder (jpuppeteer.cdp.client.entity.overlay.LineStyle snapAreaBorder) {
        this.snapAreaBorder = snapAreaBorder;
    }

    public jpuppeteer.cdp.client.entity.overlay.LineStyle getSnapAreaBorder() {
        return this.snapAreaBorder;
    }

    public void setScrollMarginColor (jpuppeteer.cdp.client.entity.dom.RGBA scrollMarginColor) {
        this.scrollMarginColor = scrollMarginColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getScrollMarginColor() {
        return this.scrollMarginColor;
    }

    public void setScrollPaddingColor (jpuppeteer.cdp.client.entity.dom.RGBA scrollPaddingColor) {
        this.scrollPaddingColor = scrollPaddingColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getScrollPaddingColor() {
        return this.scrollPaddingColor;
    }

    public ScrollSnapContainerHighlightConfig(jpuppeteer.cdp.client.entity.overlay.LineStyle snapportBorder, jpuppeteer.cdp.client.entity.overlay.LineStyle snapAreaBorder, jpuppeteer.cdp.client.entity.dom.RGBA scrollMarginColor, jpuppeteer.cdp.client.entity.dom.RGBA scrollPaddingColor) {
        this.snapportBorder = snapportBorder;
        this.snapAreaBorder = snapAreaBorder;
        this.scrollMarginColor = scrollMarginColor;
        this.scrollPaddingColor = scrollPaddingColor;
    }

    public ScrollSnapContainerHighlightConfig() {
        this.snapportBorder = null;
        this.snapAreaBorder = null;
        this.scrollMarginColor = null;
        this.scrollPaddingColor = null;
    }

}