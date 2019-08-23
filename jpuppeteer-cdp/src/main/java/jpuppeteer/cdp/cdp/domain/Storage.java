package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class Storage {

    private jpuppeteer.cdp.CDPSession session;

    public Storage(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Clears storage for origin.
    * experimental
    */
    public void clearDataForOrigin(jpuppeteer.cdp.cdp.entity.storage.ClearDataForOriginRequest request, int timeout) throws Exception {
        session.send("Storage.clearDataForOrigin", request, timeout);
    }


    /**
    * Returns usage and quota in bytes.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.storage.GetUsageAndQuotaResponse getUsageAndQuota(jpuppeteer.cdp.cdp.entity.storage.GetUsageAndQuotaRequest request, int timeout) throws Exception {
        return session.send("Storage.getUsageAndQuota", request, jpuppeteer.cdp.cdp.entity.storage.GetUsageAndQuotaResponse.class, timeout);
    }


    /**
    * Registers origin to be notified when an update occurs to its cache storage list.
    * experimental
    */
    public void trackCacheStorageForOrigin(jpuppeteer.cdp.cdp.entity.storage.TrackCacheStorageForOriginRequest request, int timeout) throws Exception {
        session.send("Storage.trackCacheStorageForOrigin", request, timeout);
    }


    /**
    * Registers origin to be notified when an update occurs to its IndexedDB.
    * experimental
    */
    public void trackIndexedDBForOrigin(jpuppeteer.cdp.cdp.entity.storage.TrackIndexedDBForOriginRequest request, int timeout) throws Exception {
        session.send("Storage.trackIndexedDBForOrigin", request, timeout);
    }


    /**
    * Unregisters origin from receiving notifications for cache storage.
    * experimental
    */
    public void untrackCacheStorageForOrigin(jpuppeteer.cdp.cdp.entity.storage.UntrackCacheStorageForOriginRequest request, int timeout) throws Exception {
        session.send("Storage.untrackCacheStorageForOrigin", request, timeout);
    }


    /**
    * Unregisters origin from receiving notifications for IndexedDB.
    * experimental
    */
    public void untrackIndexedDBForOrigin(jpuppeteer.cdp.cdp.entity.storage.UntrackIndexedDBForOriginRequest request, int timeout) throws Exception {
        session.send("Storage.untrackIndexedDBForOrigin", request, timeout);
    }

}