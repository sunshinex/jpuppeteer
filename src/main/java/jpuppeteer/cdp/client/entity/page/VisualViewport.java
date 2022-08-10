package jpuppeteer.cdp.client.entity.page;

/**
* Visual viewport position, dimensions, and scale.
*/
public class VisualViewport {

    /**
    * Horizontal offset relative to the layout viewport (CSS pixels).
    */
    private java.math.BigDecimal offsetX;

    /**
    * Vertical offset relative to the layout viewport (CSS pixels).
    */
    private java.math.BigDecimal offsetY;

    /**
    * Horizontal offset relative to the document (CSS pixels).
    */
    private java.math.BigDecimal pageX;

    /**
    * Vertical offset relative to the document (CSS pixels).
    */
    private java.math.BigDecimal pageY;

    /**
    * Width (CSS pixels), excludes scrollbar if present.
    */
    private java.math.BigDecimal clientWidth;

    /**
    * Height (CSS pixels), excludes scrollbar if present.
    */
    private java.math.BigDecimal clientHeight;

    /**
    * Scale relative to the ideal viewport (size at width=device-width).
    */
    private java.math.BigDecimal scale;

    /**
    * Page zoom factor (CSS to device independent pixels ratio).
    */
    private java.math.BigDecimal zoom;

    public void setOffsetX (java.math.BigDecimal offsetX) {
        this.offsetX = offsetX;
    }

    public java.math.BigDecimal getOffsetX() {
        return this.offsetX;
    }

    public void setOffsetY (java.math.BigDecimal offsetY) {
        this.offsetY = offsetY;
    }

    public java.math.BigDecimal getOffsetY() {
        return this.offsetY;
    }

    public void setPageX (java.math.BigDecimal pageX) {
        this.pageX = pageX;
    }

    public java.math.BigDecimal getPageX() {
        return this.pageX;
    }

    public void setPageY (java.math.BigDecimal pageY) {
        this.pageY = pageY;
    }

    public java.math.BigDecimal getPageY() {
        return this.pageY;
    }

    public void setClientWidth (java.math.BigDecimal clientWidth) {
        this.clientWidth = clientWidth;
    }

    public java.math.BigDecimal getClientWidth() {
        return this.clientWidth;
    }

    public void setClientHeight (java.math.BigDecimal clientHeight) {
        this.clientHeight = clientHeight;
    }

    public java.math.BigDecimal getClientHeight() {
        return this.clientHeight;
    }

    public void setScale (java.math.BigDecimal scale) {
        this.scale = scale;
    }

    public java.math.BigDecimal getScale() {
        return this.scale;
    }

    public void setZoom (java.math.BigDecimal zoom) {
        this.zoom = zoom;
    }

    public java.math.BigDecimal getZoom() {
        return this.zoom;
    }

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

    public VisualViewport() {
    }

}