package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for the highlighting of page elements.
* experimental
*/
public class HighlightConfig {

    /**
    * Whether the node info tooltip should be shown (default: false).
    */
    public final Boolean showInfo;

    /**
    * Whether the node styles in the tooltip (default: false).
    */
    public final Boolean showStyles;

    /**
    * Whether the rulers should be shown (default: false).
    */
    public final Boolean showRulers;

    /**
    * Whether the extension lines from node to the rulers should be shown (default: false).
    */
    public final Boolean showExtensionLines;

    /**
    * The content box highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA contentColor;

    /**
    * The padding highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA paddingColor;

    /**
    * The border highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA borderColor;

    /**
    * The margin highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA marginColor;

    /**
    * The event target element highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA eventTargetColor;

    /**
    * The shape outside fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA shapeColor;

    /**
    * The shape margin fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA shapeMarginColor;

    /**
    * The grid layout color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA cssGridColor;

    public HighlightConfig(Boolean showInfo, Boolean showStyles, Boolean showRulers, Boolean showExtensionLines, jpuppeteer.cdp.client.entity.dom.RGBA contentColor, jpuppeteer.cdp.client.entity.dom.RGBA paddingColor, jpuppeteer.cdp.client.entity.dom.RGBA borderColor, jpuppeteer.cdp.client.entity.dom.RGBA marginColor, jpuppeteer.cdp.client.entity.dom.RGBA eventTargetColor, jpuppeteer.cdp.client.entity.dom.RGBA shapeColor, jpuppeteer.cdp.client.entity.dom.RGBA shapeMarginColor, jpuppeteer.cdp.client.entity.dom.RGBA cssGridColor) {
        this.showInfo = showInfo;
        this.showStyles = showStyles;
        this.showRulers = showRulers;
        this.showExtensionLines = showExtensionLines;
        this.contentColor = contentColor;
        this.paddingColor = paddingColor;
        this.borderColor = borderColor;
        this.marginColor = marginColor;
        this.eventTargetColor = eventTargetColor;
        this.shapeColor = shapeColor;
        this.shapeMarginColor = shapeMarginColor;
        this.cssGridColor = cssGridColor;
    }

    public HighlightConfig() {
        this.showInfo = null;
        this.showStyles = null;
        this.showRulers = null;
        this.showExtensionLines = null;
        this.contentColor = null;
        this.paddingColor = null;
        this.borderColor = null;
        this.marginColor = null;
        this.eventTargetColor = null;
        this.shapeColor = null;
        this.shapeMarginColor = null;
        this.cssGridColor = null;
    }

}