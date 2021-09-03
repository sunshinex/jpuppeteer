package jpuppeteer.cdp.client.entity.overlay;

/**
* Style information for drawing a line.
* experimental
*/
public class LineStyle {

    /**
    * The color of the line (default: transparent)
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA color;

    /**
    * The line pattern (default: solid)
    */
    public final jpuppeteer.cdp.client.constant.overlay.LineStylePattern pattern;

    public LineStyle(jpuppeteer.cdp.client.entity.dom.RGBA color, jpuppeteer.cdp.client.constant.overlay.LineStylePattern pattern) {
        this.color = color;
        this.pattern = pattern;
    }

    public LineStyle() {
        this.color = null;
        this.pattern = null;
    }

}