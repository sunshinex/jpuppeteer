package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration data for drawing the source order of an elements children.
* experimental
*/
public class SourceOrderConfig {

    /**
    * the color to outline the givent element in.
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA parentOutlineColor;

    /**
    * the color to outline the child elements in.
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA childOutlineColor;

    public SourceOrderConfig(jpuppeteer.cdp.client.entity.dom.RGBA parentOutlineColor, jpuppeteer.cdp.client.entity.dom.RGBA childOutlineColor) {
        this.parentOutlineColor = parentOutlineColor;
        this.childOutlineColor = childOutlineColor;
    }

}