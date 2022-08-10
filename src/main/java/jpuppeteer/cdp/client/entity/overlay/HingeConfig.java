package jpuppeteer.cdp.client.entity.overlay;

/**
* Configuration for dual screen hinge
* experimental
*/
public class HingeConfig {

    /**
    * A rectangle represent hinge
    */
    private jpuppeteer.cdp.client.entity.dom.Rect rect;

    /**
    * The content box highlight fill color (default: a dark color).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA contentColor;

    /**
    * The content box highlight outline color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA outlineColor;

    public void setRect (jpuppeteer.cdp.client.entity.dom.Rect rect) {
        this.rect = rect;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getRect() {
        return this.rect;
    }

    public void setContentColor (jpuppeteer.cdp.client.entity.dom.RGBA contentColor) {
        this.contentColor = contentColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getContentColor() {
        return this.contentColor;
    }

    public void setOutlineColor (jpuppeteer.cdp.client.entity.dom.RGBA outlineColor) {
        this.outlineColor = outlineColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getOutlineColor() {
        return this.outlineColor;
    }

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

    public HingeConfig() {
    }

}