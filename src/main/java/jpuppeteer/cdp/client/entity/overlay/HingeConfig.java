package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration for dual screen hinge
* experimental
*/
public class HingeConfig {

    /**
    * A rectangle represent hinge
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect rect;

    /**
    * The content box highlight fill color (default: a dark color).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA contentColor;

    /**
    * The content box highlight outline color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA outlineColor;

    public HingeConfig(jpuppeteer.cdp.client.entity.dom.Rect rect, jpuppeteer.cdp.client.entity.dom.RGBA contentColor, jpuppeteer.cdp.client.entity.dom.RGBA outlineColor) {
        this.rect = rect;
        this.contentColor = contentColor;
        this.outlineColor = outlineColor;
    }

    public HingeConfig(jpuppeteer.cdp.client.entity.dom.Rect rect) {
        this.rect = rect;
        this.contentColor = null;
        this.outlineColor = null;
    }

}