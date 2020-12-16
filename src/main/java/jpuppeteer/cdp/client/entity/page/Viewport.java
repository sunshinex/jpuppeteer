package jpuppeteer.cdp.client.entity.page;

/**
* Viewport for capturing screenshot.
*/
public class Viewport {

    /**
    * X offset in device independent pixels (dip).
    */
    public final java.math.BigDecimal x;

    /**
    * Y offset in device independent pixels (dip).
    */
    public final java.math.BigDecimal y;

    /**
    * Rectangle width in device independent pixels (dip).
    */
    public final java.math.BigDecimal width;

    /**
    * Rectangle height in device independent pixels (dip).
    */
    public final java.math.BigDecimal height;

    /**
    * Page scale factor.
    */
    public final java.math.BigDecimal scale;

    public Viewport(java.math.BigDecimal x, java.math.BigDecimal y, java.math.BigDecimal width, java.math.BigDecimal height, java.math.BigDecimal scale) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scale = scale;
    }

}