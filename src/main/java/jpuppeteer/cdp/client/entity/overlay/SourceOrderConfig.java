package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for drawing the source order of an elements children.
* experimental
*/
public class SourceOrderConfig {

    /**
    * the color to outline the givent element in.
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA parentOutlineColor;

    /**
    * the color to outline the child elements in.
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA childOutlineColor;

    public void setParentOutlineColor (jpuppeteer.cdp.client.entity.dom.RGBA parentOutlineColor) {
        this.parentOutlineColor = parentOutlineColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getParentOutlineColor() {
        return this.parentOutlineColor;
    }

    public void setChildOutlineColor (jpuppeteer.cdp.client.entity.dom.RGBA childOutlineColor) {
        this.childOutlineColor = childOutlineColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getChildOutlineColor() {
        return this.childOutlineColor;
    }

    public SourceOrderConfig(jpuppeteer.cdp.client.entity.dom.RGBA parentOutlineColor, jpuppeteer.cdp.client.entity.dom.RGBA childOutlineColor) {
        this.parentOutlineColor = parentOutlineColor;
        this.childOutlineColor = childOutlineColor;
    }

    public SourceOrderConfig() {
    }

}