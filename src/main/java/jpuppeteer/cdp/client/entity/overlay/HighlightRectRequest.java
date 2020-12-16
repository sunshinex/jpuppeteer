package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightRectRequest {

    /**
    * X coordinate
    */
    public final Integer x;

    /**
    * Y coordinate
    */
    public final Integer y;

    /**
    * Rectangle width
    */
    public final Integer width;

    /**
    * Rectangle height
    */
    public final Integer height;

    /**
    * The highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA color;

    /**
    * The highlight outline color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA outlineColor;

    public HighlightRectRequest(Integer x, Integer y, Integer width, Integer height, jpuppeteer.cdp.client.entity.dom.RGBA color, jpuppeteer.cdp.client.entity.dom.RGBA outlineColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    public HighlightRectRequest(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = null;
        this.outlineColor = null;
    }

}