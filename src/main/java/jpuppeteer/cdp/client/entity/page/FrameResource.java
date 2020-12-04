package jpuppeteer.cdp.client.entity.page;

/**
* Information about the Resource on the page.
*/
public class FrameResource {

    /**
    * Resource URL.
    */
    public final String url;

    /**
    * Type of this resource.
    */
    public final String type;

    /**
    * Resource mimeType as determined by the browser.
    */
    public final String mimeType;

    /**
    * last-modified timestamp as reported by server.
    */
    public final java.math.BigDecimal lastModified;

    /**
    * Resource content size.
    */
    public final java.math.BigDecimal contentSize;

    /**
    * True if the resource failed to load.
    */
    public final Boolean failed;

    /**
    * True if the resource was canceled during loading.
    */
    public final Boolean canceled;

    public FrameResource(String url, String type, String mimeType, java.math.BigDecimal lastModified, java.math.BigDecimal contentSize, Boolean failed, Boolean canceled) {
        this.url = url;
        this.type = type;
        this.mimeType = mimeType;
        this.lastModified = lastModified;
        this.contentSize = contentSize;
        this.failed = failed;
        this.canceled = canceled;
    }

    public FrameResource(String url, String type, String mimeType) {
        this.url = url;
        this.type = type;
        this.mimeType = mimeType;
        this.lastModified = null;
        this.contentSize = null;
        this.failed = null;
        this.canceled = null;
    }

}