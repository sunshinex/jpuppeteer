package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
* experimental
*/
public class LargestContentfulPaint {

    /**
    */
    private java.math.BigDecimal renderTime;

    /**
    */
    private java.math.BigDecimal loadTime;

    /**
    * The number of pixels being painted.
    */
    private java.math.BigDecimal size;

    /**
    * The id attribute of the element, if available.
    */
    private String elementId;

    /**
    * The URL of the image (may be trimmed).
    */
    private String url;

    /**
    */
    private Integer nodeId;

    public void setRenderTime (java.math.BigDecimal renderTime) {
        this.renderTime = renderTime;
    }

    public java.math.BigDecimal getRenderTime() {
        return this.renderTime;
    }

    public void setLoadTime (java.math.BigDecimal loadTime) {
        this.loadTime = loadTime;
    }

    public java.math.BigDecimal getLoadTime() {
        return this.loadTime;
    }

    public void setSize (java.math.BigDecimal size) {
        this.size = size;
    }

    public java.math.BigDecimal getSize() {
        return this.size;
    }

    public void setElementId (String elementId) {
        this.elementId = elementId;
    }

    public String getElementId() {
        return this.elementId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

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

    public LargestContentfulPaint() {
    }

}