package jpuppeteer.cdp.client.entity.dom;

/**
* CSS Shape Outside details.
*/
public class ShapeOutsideInfo {

    /**
    * Shape bounds
    */
    public final java.util.List<java.math.BigDecimal> bounds;

    /**
    * Shape coordinate details
    */
    public final java.util.List<Object> shape;

    /**
    * Margin shape bounds
    */
    public final java.util.List<Object> marginShape;

    public ShapeOutsideInfo(java.util.List<java.math.BigDecimal> bounds, java.util.List<Object> shape, java.util.List<Object> marginShape) {
        this.bounds = bounds;
        this.shape = shape;
        this.marginShape = marginShape;
    }

}