package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class CacheStorage {

    private jpuppeteer.cdp.CDPConnection connection;

    public CacheStorage(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Deletes a cache.
    */
    public jpuppeteer.util.XFuture<?> deleteCache(jpuppeteer.cdp.client.entity.cachestorage.DeleteCacheRequest request) {
        return connection.send("CacheStorage.deleteCache", request);
    }


    /**
    * Deletes a cache entry.
    */
    public jpuppeteer.util.XFuture<?> deleteEntry(jpuppeteer.cdp.client.entity.cachestorage.DeleteEntryRequest request) {
        return connection.send("CacheStorage.deleteEntry", request);
    }


    /**
    * Requests cache names.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.cachestorage.RequestCacheNamesResponse> requestCacheNames(jpuppeteer.cdp.client.entity.cachestorage.RequestCacheNamesRequest request) {
        return connection.send("CacheStorage.requestCacheNames", request, jpuppeteer.cdp.client.entity.cachestorage.RequestCacheNamesResponse.class);
    }


    /**
    * Fetches cache entry.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.cachestorage.RequestCachedResponseResponse> requestCachedResponse(jpuppeteer.cdp.client.entity.cachestorage.RequestCachedResponseRequest request) {
        return connection.send("CacheStorage.requestCachedResponse", request, jpuppeteer.cdp.client.entity.cachestorage.RequestCachedResponseResponse.class);
    }


    /**
    * Requests data from cache.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.cachestorage.RequestEntriesResponse> requestEntries(jpuppeteer.cdp.client.entity.cachestorage.RequestEntriesRequest request) {
        return connection.send("CacheStorage.requestEntries", request, jpuppeteer.cdp.client.entity.cachestorage.RequestEntriesResponse.class);
    }

}