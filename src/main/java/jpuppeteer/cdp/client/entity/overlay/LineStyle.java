package jpuppeteer.cdp.client.entity.overlay;

/**
* Style information for drawing a line.
* experimental
*/
public class LineStyle {

    /**
    * The color of the line (default: transparent)
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA color;

    /**
    * The line pattern (default: solid)
    */
    private jpuppeteer.cdp.client.constant.overlay.LineStylePattern pattern;

    public void setColor (jpuppeteer.cdp.client.entity.dom.RGBA color) {
        this.color = color;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getColor() {
        return this.color;
    }

    public void setPattern (jpuppeteer.cdp.client.constant.overlay.LineStylePattern pattern) {
        this.pattern = pattern;
    }

    public jpuppeteer.cdp.client.constant.overlay.LineStylePattern getPattern() {
        return this.pattern;
    }

    public LineStyle(jpuppeteer.cdp.client.entity.dom.RGBA color, jpuppeteer.cdp.client.constant.overlay.LineStylePattern pattern) {
        this.color = color;
        this.pattern = pattern;
    }

    public LineStyle() {
        this.color = null;
        this.pattern = null;
    }

}