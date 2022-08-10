package jpuppeteer.cdp.client.entity.cachestorage;

/**
* Cache identifier.
* experimental
*/
public class Cache {

    /**
    * An opaque unique id of the cache.
    */
    private String cacheId;

    /**
    * Security origin of the cache.
    */
    private String securityOrigin;

    /**
    * The name of the cache.
    */
    private String cacheName;

    public void setCacheId (String cacheId) {
        this.cacheId = cacheId;
    }

    public String getCacheId() {
        return this.cacheId;
    }

    public void setSecurityOrigin (String securityOrigin) {
        this.securityOrigin = securityOrigin;
    }

    public String getSecurityOrigin() {
        return this.securityOrigin;
    }

    public void setCacheName (String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheName() {
        return this.cacheName;
    }

    public Cache(String cacheId, String securityOrigin, String cacheName) {
        this.cacheId = cacheId;
        this.securityOrigin = securityOrigin;
        this.cacheName = cacheName;
    }

    public Cache() {
    }

}