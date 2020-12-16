package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightQuadRequest {

    /**
    * Quad to highlight
    */
    public final java.util.List<java.math.BigDecimal> quad;

    /**
    * The highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA color;

    /**
    * The highlight outline color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA outlineColor;

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

}