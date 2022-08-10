package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightRectRequest {

    /**
    * X coordinate
    */
    private Integer x;

    /**
    * Y coordinate
    */
    private Integer y;

    /**
    * Rectangle width
    */
    private Integer width;

    /**
    * Rectangle height
    */
    private Integer height;

    /**
    * The highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA color;

    /**
    * The highlight outline color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA outlineColor;

    public void setX (Integer x) {
        this.x = x;
    }

    public Integer getX() {
        return this.x;
    }

    public void setY (Integer y) {
        this.y = y;
    }

    public Integer getY() {
        return this.y;
    }

    public void setWidth (Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setHeight (Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setColor (jpuppeteer.cdp.client.entity.dom.RGBA color) {
        this.color = color;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getColor() {
        return this.color;
    }

    public void setOutlineColor (jpuppeteer.cdp.client.entity.dom.RGBA outlineColor) {
        this.outlineColor = outlineColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getOutlineColor() {
        return this.outlineColor;
    }

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

    public HighlightRectRequest() {
    }

}