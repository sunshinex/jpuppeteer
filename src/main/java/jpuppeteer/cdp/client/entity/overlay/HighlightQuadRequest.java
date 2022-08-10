package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightQuadRequest {

    /**
    * Quad to highlight
    */
    private java.util.List<java.math.BigDecimal> quad;

    /**
    * The highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA color;

    /**
    * The highlight outline color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA outlineColor;

    public void setQuad (java.util.List<java.math.BigDecimal> quad) {
        this.quad = quad;
    }

    public java.util.List<java.math.BigDecimal> getQuad() {
        return this.quad;
    }

    public void setColor (jpuppeteer.cdp.client.entity.dom.RGBA color) {
        this.color = color;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getColor() {
        return this.color;
    }

    public void setOutlineColor (jpuppeteer.cdp.client.entity.dom.RGBA outlineColor) {
        this.outlineColor = outlineColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getOutlineColor() {
        return this.outlineColor;
    }

    public HighlightQuadRequest(java.util.List<java.math.BigDecimal> quad, jpuppeteer.cdp.client.entity.dom.RGBA color, jpuppeteer.cdp.client.entity.dom.RGBA outlineColor) {
        this.quad = quad;
        this.color = color;
        this.outlineColor = outlineColor;
    }

    public HighlightQuadRequest(java.util.List<java.math.BigDecimal> quad) {
        this.quad = quad;
        this.color = null;
        this.outlineColor = null;
    }

    public HighlightQuadRequest() {
    }

}