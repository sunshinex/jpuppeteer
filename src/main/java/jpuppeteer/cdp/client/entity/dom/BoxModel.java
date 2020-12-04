package jpuppeteer.cdp.client.entity.dom;

/**
* Box model.
*/
public class BoxModel {

    /**
    * Content box
    */
    public final java.util.List<java.math.BigDecimal> content;

    /**
    * Padding box
    */
    public final java.util.List<java.math.BigDecimal> padding;

    /**
    * Border box
    */
    public final java.util.List<java.math.BigDecimal> border;

    /**
    * Margin box
    */
    public final java.util.List<java.math.BigDecimal> margin;

    /**
    * Node width
    */
    public final Integer width;

    /**
    * Node height
    */
    public final Integer height;

    /**
    * Shape outside coordinates
    */
    public final jpuppeteer.cdp.client.entity.dom.ShapeOutsideInfo shapeOutside;

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

}