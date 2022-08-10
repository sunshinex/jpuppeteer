package jpuppeteer.cdp.client.entity.applicationcache;

/**
* Detailed application cache information.
* experimental
*/
public class ApplicationCache {

    /**
    * Manifest URL.
    */
    private String manifestURL;

    /**
    * Application cache size.
    */
    private java.math.BigDecimal size;

    /**
    * Application cache creation time.
    */
    private java.math.BigDecimal creationTime;

    /**
    * Application cache update time.
    */
    private java.math.BigDecimal updateTime;

    /**
    * Application cache resources.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.applicationcache.ApplicationCacheResource> resources;

    public void setManifestURL (String manifestURL) {
        this.manifestURL = manifestURL;
    }

    public String getManifestURL() {
        return this.manifestURL;
    }

    public void setSize (java.math.BigDecimal size) {
        this.size = size;
    }

    public java.math.BigDecimal getSize() {
        return this.size;
    }

    public void setCreationTime (java.math.BigDecimal creationTime) {
        this.creationTime = creationTime;
    }

    public java.math.BigDecimal getCreationTime() {
        return this.creationTime;
    }

    public void setUpdateTime (java.math.BigDecimal updateTime) {
        this.updateTime = updateTime;
    }

    public java.math.BigDecimal getUpdateTime() {
        return this.updateTime;
    }

    public void setResources (java.util.List<jpuppeteer.cdp.client.entity.applicationcache.ApplicationCacheResource> resources) {
        this.resources = resources;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.applicationcache.ApplicationCacheResource> getResources() {
        return this.resources;
    }

    public ApplicationCache(String manifestURL, java.math.BigDecimal size, java.math.BigDecimal creationTime, java.math.BigDecimal updateTime, java.util.List<jpuppeteer.cdp.client.entity.applicationcache.ApplicationCacheResource> resources) {
        this.manifestURL = manifestURL;
        this.size = size;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
        this.resources = resources;
    }

    public ApplicationCache() {
    }

}