package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void deleteCache(jpuppeteer.cdp.cdp.entity.cachestorage.DeleteCacheRequest request, int timeout) throws Exception {
        session.send("CacheStorage.deleteCache", request, timeout);
    }


    /**
    * Deletes a cache entry.
    * experimental
    */
    public void deleteEntry(jpuppeteer.cdp.cdp.entity.cachestorage.DeleteEntryRequest request, int timeout) throws Exception {
        session.send("CacheStorage.deleteEntry", request, timeout);
    }


    /**
    * Requests cache names.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.cachestorage.RequestCacheNamesResponse requestCacheNames(jpuppeteer.cdp.cdp.entity.cachestorage.RequestCacheNamesRequest request, int timeout) throws Exception {
        return session.send("CacheStorage.requestCacheNames", request, jpuppeteer.cdp.cdp.entity.cachestorage.RequestCacheNamesResponse.class, timeout);
    }


    /**
    * Fetches cache entry.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.cachestorage.RequestCachedResponseResponse requestCachedResponse(jpuppeteer.cdp.cdp.entity.cachestorage.RequestCachedResponseRequest request, int timeout) throws Exception {
        return session.send("CacheStorage.requestCachedResponse", request, jpuppeteer.cdp.cdp.entity.cachestorage.RequestCachedResponseResponse.class, timeout);
    }


    /**
    * Requests data from cache.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.cachestorage.RequestEntriesResponse requestEntries(jpuppeteer.cdp.cdp.entity.cachestorage.RequestEntriesRequest request, int timeout) throws Exception {
        return session.send("CacheStorage.requestEntries", request, jpuppeteer.cdp.cdp.entity.cachestorage.RequestEntriesResponse.class, timeout);
    }

}