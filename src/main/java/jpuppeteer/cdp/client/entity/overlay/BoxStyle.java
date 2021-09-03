package jpuppeteer.cdp.client.entity.overlay;

/**
* Style information for drawing a box.
* experimental
*/
public class BoxStyle {

    /**
    * The background color for the box (default: transparent)
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA fillColor;

    /**
    * The hatching color for the box (default: transparent)
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA hatchColor;

    public BoxStyle(jpuppeteer.cdp.client.entity.dom.RGBA fillColor, jpuppeteer.cdp.client.entity.dom.RGBA hatchColor) {
        this.fillColor = fillColor;
        this.hatchColor = hatchColor;
    }

    public BoxStyle() {
        this.fillColor = null;
        this.hatchColor = null;
    }

}