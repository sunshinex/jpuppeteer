package jpuppeteer.cdp.client.entity.dom;

/**
* Rectangle.
*/
public class Rect {

    /**
    * X coordinate
    */
    public final java.math.BigDecimal x;

    /**
    * Y coordinate
    */
    public final java.math.BigDecimal y;

    /**
    * Rectangle width
    */
    public final java.math.BigDecimal width;

    /**
    * Rectangle height
    */
    public final java.math.BigDecimal height;

    public Rect(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal width, java.math.BigDecimal height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}