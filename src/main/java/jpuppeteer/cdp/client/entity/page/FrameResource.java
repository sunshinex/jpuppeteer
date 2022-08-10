package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Resource on the page.
*/
public class FrameResource {

    /**
    * Resource URL.
    */
    private String url;

    /**
    * Type of this resource.
    */
    private jpuppeteer.cdp.client.constant.network.ResourceType type;

    /**
    * Resource mimeType as determined by the browser.
    */
    private String mimeType;

    /**
    * last-modified timestamp as reported by server.
    */
    private java.math.BigDecimal lastModified;

    /**
    * Resource content size.
    */
    private java.math.BigDecimal contentSize;

    /**
    * True if the resource failed to load.
    */
    private Boolean failed;

    /**
    * True if the resource was canceled during loading.
    */
    private Boolean canceled;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setType (jpuppeteer.cdp.client.constant.network.ResourceType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.network.ResourceType getType() {
        return this.type;
    }

    public void setMimeType (String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setLastModified (java.math.BigDecimal lastModified) {
        this.lastModified = lastModified;
    }

    public java.math.BigDecimal getLastModified() {
        return this.lastModified;
    }

    public void setContentSize (java.math.BigDecimal contentSize) {
        this.contentSize = contentSize;
    }

    public java.math.BigDecimal getContentSize() {
        return this.contentSize;
    }

    public void setFailed (Boolean failed) {
        this.failed = failed;
    }

    public Boolean getFailed() {
        return this.failed;
    }

    public void setCanceled (Boolean canceled) {
        this.canceled = canceled;
    }

    public Boolean getCanceled() {
        return this.canceled;
    }

    public FrameResource(String url, jpuppeteer.cdp.client.constant.network.ResourceType type, String mimeType, java.math.BigDecimal lastModified, java.math.BigDecimal contentSize, Boolean failed, Boolean canceled) {
        this.url = url;
        this.type = type;
        this.mimeType = mimeType;
        this.lastModified = lastModified;
        this.contentSize = contentSize;
        this.failed = failed;
        this.canceled = canceled;
    }

    public FrameResource(String url, jpuppeteer.cdp.client.constant.network.ResourceType type, String mimeType) {
        this.url = url;
        this.type = type;
        this.mimeType = mimeType;
        this.lastModified = null;
        this.contentSize = null;
        this.failed = null;
        this.canceled = null;
    }

    public FrameResource() {
    }

}