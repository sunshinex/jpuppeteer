package jpuppeteer.cdp.client.entity.overlay;

/**
* Style information for drawing a box.
* experimental
*/
public class BoxStyle {

    /**
    * The background color for the box (default: transparent)
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA fillColor;

    /**
    * The hatching color for the box (default: transparent)
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA hatchColor;

    public void setFillColor (jpuppeteer.cdp.client.entity.dom.RGBA fillColor) {
        this.fillColor = fillColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getFillColor() {
        return this.fillColor;
    }

    public void setHatchColor (jpuppeteer.cdp.client.entity.dom.RGBA hatchColor) {
        this.hatchColor = hatchColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getHatchColor() {
        return this.hatchColor;
    }

    public BoxStyle(jpuppeteer.cdp.client.entity.dom.RGBA fillColor, jpuppeteer.cdp.client.entity.dom.RGBA hatchColor) {
        this.fillColor = fillColor;
        this.hatchColor = hatchColor;
    }

    public BoxStyle() {
        this.fillColor = null;
        this.hatchColor = null;
    }

}