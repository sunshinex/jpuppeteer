package jpuppeteer.cdp.client.entity.dom;

/**
* CSS Shape Outside details.
*/
public class ShapeOutsideInfo {

    /**
    * Shape bounds
    */
    private java.util.List<java.math.BigDecimal> bounds;

    /**
    * Shape coordinate details
    */
    private java.util.List<Object> shape;

    /**
    * Margin shape bounds
    */
    private java.util.List<Object> marginShape;

    public void setBounds (java.util.List<java.math.BigDecimal> bounds) {
        this.bounds = bounds;
    }

    public java.util.List<java.math.BigDecimal> getBounds() {
        return this.bounds;
    }

    public void setShape (java.util.List<Object> shape) {
        this.shape = shape;
    }

    public java.util.List<Object> getShape() {
        return this.shape;
    }

    public void setMarginShape (java.util.List<Object> marginShape) {
        this.marginShape = marginShape;
    }

    public java.util.List<Object> getMarginShape() {
        return this.marginShape;
    }

    public ShapeOutsideInfo(java.util.List<java.math.BigDecimal> bounds, java.util.List<Object> shape, java.util.List<Object> marginShape) {
        this.bounds = bounds;
        this.shape = shape;
        this.marginShape = marginShape;
    }

    public ShapeOutsideInfo() {
    }

}