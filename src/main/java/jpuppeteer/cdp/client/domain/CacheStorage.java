package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class CacheStorage {

    private jpuppeteer.cdp.CDPSession session;

    public CacheStorage(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Deletes a cache.
    */
    public io.netty.util.concurrent.Future deleteCache(jpuppeteer.cdp.client.entity.cachestorage.DeleteCacheRequest request) {
        return session.send("CacheStorage.deleteCache", request);
    }


    /**
    * Deletes a cache entry.
    */
    public io.netty.util.concurrent.Future deleteEntry(jpuppeteer.cdp.client.entity.cachestorage.DeleteEntryRequest request) {
        return session.send("CacheStorage.deleteEntry", request);
    }


    /**
    * Requests cache names.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.cachestorage.RequestCacheNamesResponse> requestCacheNames(jpuppeteer.cdp.client.entity.cachestorage.RequestCacheNamesRequest request) {
        return session.send("CacheStorage.requestCacheNames", request, jpuppeteer.cdp.client.entity.cachestorage.RequestCacheNamesResponse.class);
    }


    /**
    * Fetches cache entry.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.cachestorage.RequestCachedResponseResponse> requestCachedResponse(jpuppeteer.cdp.client.entity.cachestorage.RequestCachedResponseRequest request) {
        return session.send("CacheStorage.requestCachedResponse", request, jpuppeteer.cdp.client.entity.cachestorage.RequestCachedResponseResponse.class);
    }


    /**
    * Requests data from cache.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.cachestorage.RequestEntriesResponse> requestEntries(jpuppeteer.cdp.client.entity.cachestorage.RequestEntriesRequest request) {
        return session.send("CacheStorage.requestEntries", request, jpuppeteer.cdp.client.entity.cachestorage.RequestEntriesResponse.class);
    }

}