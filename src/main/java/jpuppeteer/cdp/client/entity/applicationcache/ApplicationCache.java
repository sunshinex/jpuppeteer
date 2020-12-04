package jpuppeteer.cdp.client.entity.applicationcache;

/**
* Detailed application cache information.
* experimental
*/
public class ApplicationCache {

    /**
    * Manifest URL.
    */
    public final String manifestURL;

    /**
    * Application cache size.
    */
    public final java.math.BigDecimal size;

    /**
    * Application cache creation time.
    */
    public final java.math.BigDecimal creationTime;

    /**
    * Application cache update time.
    */
    public final java.math.BigDecimal updateTime;

    /**
    * Application cache resources.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.applicationcache.ApplicationCacheResource> resources;

    public ApplicationCache(String manifestURL, java.math.BigDecimal size, java.math.BigDecimal creationTime, java.math.BigDecimal updateTime, java.util.List<jpuppeteer.cdp.client.entity.applicationcache.ApplicationCacheResource> resources) {
        this.manifestURL = manifestURL;
        this.size = size;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
        this.resources = resources;
    }

}