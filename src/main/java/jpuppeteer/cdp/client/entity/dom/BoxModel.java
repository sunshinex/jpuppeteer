package jpuppeteer.cdp.client.entity.dom;

/**
* Box model.
*/
public class BoxModel {

    /**
    * Content box
    */
    private java.util.List<java.math.BigDecimal> content;

    /**
    * Padding box
    */
    private java.util.List<java.math.BigDecimal> padding;

    /**
    * Border box
    */
    private java.util.List<java.math.BigDecimal> border;

    /**
    * Margin box
    */
    private java.util.List<java.math.BigDecimal> margin;

    /**
    * Node width
    */
    private Integer width;

    /**
    * Node height
    */
    private Integer height;

    /**
    * Shape outside coordinates
    */
    private jpuppeteer.cdp.client.entity.dom.ShapeOutsideInfo shapeOutside;

    public void setContent (java.util.List<java.math.BigDecimal> content) {
        this.content = content;
    }

    public java.util.List<java.math.BigDecimal> getContent() {
        return this.content;
    }

    public void setPadding (java.util.List<java.math.BigDecimal> padding) {
        this.padding = padding;
    }

    public java.util.List<java.math.BigDecimal> getPadding() {
        return this.padding;
    }

    public void setBorder (java.util.List<java.math.BigDecimal> border) {
        this.border = border;
    }

    public java.util.List<java.math.BigDecimal> getBorder() {
        return this.border;
    }

    public void setMargin (java.util.List<java.math.BigDecimal> margin) {
        this.margin = margin;
    }

    public java.util.List<java.math.BigDecimal> getMargin() {
        return this.margin;
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

    public void setShapeOutside (jpuppeteer.cdp.client.entity.dom.ShapeOutsideInfo shapeOutside) {
        this.shapeOutside = shapeOutside;
    }

    public jpuppeteer.cdp.client.entity.dom.ShapeOutsideInfo getShapeOutside() {
        return this.shapeOutside;
    }

    public BoxModel(java.util.List<java.math.BigDecimal> content, java.util.List<java.math.BigDecimal> padding, java.util.List<java.math.BigDecimal> border, java.util.List<java.math.BigDecimal> margin, Integer width, Integer height, jpuppeteer.cdp.client.entity.dom.ShapeOutsideInfo shapeOutside) {
        this.content = content;
        this.padding = padding;
        this.border = border;
        this.margin = margin;
        this.width = width;
        this.height = height;
        this.shapeOutside = shapeOutside;
    }

    public BoxModel(java.util.List<java.math.BigDecimal> content, java.util.List<java.math.BigDecimal> padding, java.util.List<java.math.BigDecimal> border, java.util.List<java.math.BigDecimal> margin, Integer width, Integer height) {
        this.content = content;
        this.padding = padding;
        this.border = border;
        this.margin = margin;
        this.width = width;
        this.height = height;
        this.shapeOutside = null;
    }

    public BoxModel() {
    }

}