package jpuppeteer.cdp.client.entity.cachestorage;

/**
* Cache identifier.
* experimental
*/
public class Cache {

    /**
    * An opaque unique id of the cache.
    */
    public final String cacheId;

    /**
    * Security origin of the cache.
    */
    public final String securityOrigin;

    /**
    * The name of the cache.
    */
    public final String cacheName;

    public Cache(String cacheId, String securityOrigin, String cacheName) {
        this.cacheId = cacheId;
        this.securityOrigin = securityOrigin;
        this.cacheName = cacheName;
    }

}