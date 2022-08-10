package jpuppeteer.cdp.client.entity.page;

/**
* Viewport for capturing screenshot.
*/
public class Viewport {

    /**
    * X offset in device independent pixels (dip).
    */
    private java.math.BigDecimal x;

    /**
    * Y offset in device independent pixels (dip).
    */
    private java.math.BigDecimal y;

    /**
    * Rectangle width in device independent pixels (dip).
    */
    private java.math.BigDecimal width;

    /**
    * Rectangle height in device independent pixels (dip).
    */
    private java.math.BigDecimal height;

    /**
    * Page scale factor.
    */
    private java.math.BigDecimal scale;

    public void setX (java.math.BigDecimal x) {
        this.x = x;
    }

    public java.math.BigDecimal getX() {
        return this.x;
    }

    public void setY (java.math.BigDecimal y) {
        this.y = y;
    }

    public java.math.BigDecimal getY() {
        return this.y;
    }

    public void setWidth (java.math.BigDecimal width) {
        this.width = width;
    }

    public java.math.BigDecimal getWidth() {
        return this.width;
    }

    public void setHeight (java.math.BigDecimal height) {
        this.height = height;
    }

    public java.math.BigDecimal getHeight() {
        return this.height;
    }

    public void setScale (java.math.BigDecimal scale) {
        this.scale = scale;
    }

    public java.math.BigDecimal getScale() {
        return this.scale;
    }

    public Viewport(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal width, java.math.BigDecimal height, java.math.BigDecimal scale) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scale = scale;
    }

    public Viewport() {
    }

}