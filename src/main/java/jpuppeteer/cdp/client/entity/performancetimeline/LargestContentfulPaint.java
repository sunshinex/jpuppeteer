package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
* experimental
*/
public class LargestContentfulPaint {

    /**
    */
    public final java.math.BigDecimal renderTime;

    /**
    */
    public final java.math.BigDecimal loadTime;

    /**
    * The number of pixels being painted.
    */
    public final java.math.BigDecimal size;

    /**
    * The id attribute of the element, if available.
    */
    public final String elementId;

    /**
    * The URL of the image (may be trimmed).
    */
    public final String url;

    /**
    */
    public final Integer nodeId;

    public LargestContentfulPaint(java.math.BigDecimal renderTime, java.math.BigDecimal loadTime, java.math.BigDecimal size, String elementId, String url, Integer nodeId) {
        this.renderTime = renderTime;
        this.loadTime = loadTime;
        this.size = size;
        this.elementId = elementId;
        this.url = url;
        this.nodeId = nodeId;
    }

    public LargestContentfulPaint(java.math.BigDecimal renderTime, java.math.BigDecimal loadTime, java.math.BigDecimal size) {
        this.renderTime = renderTime;
        this.loadTime = loadTime;
        this.size = size;
        this.elementId = null;
        this.url = null;
        this.nodeId = null;
    }

}