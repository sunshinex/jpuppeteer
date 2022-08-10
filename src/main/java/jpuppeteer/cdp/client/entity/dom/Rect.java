package jpuppeteer.cdp.client.entity.dom;

/**
* Rectangle.
*/
public class Rect {

    /**
    * X coordinate
    */
    private java.math.BigDecimal x;

    /**
    * Y coordinate
    */
    private java.math.BigDecimal y;

    /**
    * Rectangle width
    */
    private java.math.BigDecimal width;

    /**
    * Rectangle height
    */
    private java.math.BigDecimal height;

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

    public Rect(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal width, java.math.BigDecimal height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rect() {
    }

}