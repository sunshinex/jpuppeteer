package jpuppeteer.cdp.client.entity.page;

/**
* Visual viewport position, dimensions, and scale.
*/
public class VisualViewport {

    /**
    * Horizontal offset relative to the layout viewport (CSS pixels).
    */
    public final java.math.BigDecimal offsetX;

    /**
    * Vertical offset relative to the layout viewport (CSS pixels).
    */
    public final java.math.BigDecimal offsetY;

    /**
    * Horizontal offset relative to the document (CSS pixels).
    */
    public final java.math.BigDecimal pageX;

    /**
    * Vertical offset relative to the document (CSS pixels).
    */
    public final java.math.BigDecimal pageY;

    /**
    * Width (CSS pixels), excludes scrollbar if present.
    */
    public final java.math.BigDecimal clientWidth;

    /**
    * Height (CSS pixels), excludes scrollbar if present.
    */
    public final java.math.BigDecimal clientHeight;

    /**
    * Scale relative to the ideal viewport (size at width=device-width).
    */
    public final java.math.BigDecimal scale;

    /**
    * Page zoom factor (CSS to device independent pixels ratio).
    */
    public final java.math.BigDecimal zoom;

    public VisualViewport(java.math.BigDecimal offsetX, java.math.BigDecimal offsetY, java.math.BigDecimal pageX, java.math.BigDecimal pageY, java.math.BigDecimal clientWidth, java.math.BigDecimal clientHeight, java.math.BigDecimal scale, java.math.BigDecimal zoom) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.pageX = pageX;
        this.pageY = pageY;
        this.clientWidth = clientWidth;
        this.clientHeight = clientHeight;
        this.scale = scale;
        this.zoom = zoom;
    }

    public VisualViewport(java.math.BigDecimal offsetX, java.math.BigDecimal offsetY, java.math.BigDecimal pageX, java.math.BigDecimal pageY, java.math.BigDecimal clientWidth, java.math.BigDecimal clientHeight, java.math.BigDecimal scale) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.pageX = pageX;
        this.pageY = pageY;
        this.clientWidth = clientWidth;
        this.clientHeight = clientHeight;
        this.scale = scale;
        this.zoom = null;
    }

}