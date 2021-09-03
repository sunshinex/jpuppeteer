package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class ScrollSnapContainerHighlightConfig {

    /**
    * The style of the snapport border (default: transparent)
    */
    public final jpuppeteer.cdp.client.entity.overlay.LineStyle snapportBorder;

    /**
    * The style of the snap area border (default: transparent)
    */
    public final jpuppeteer.cdp.client.entity.overlay.LineStyle snapAreaBorder;

    /**
    * The margin highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA scrollMarginColor;

    /**
    * The padding highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA scrollPaddingColor;

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