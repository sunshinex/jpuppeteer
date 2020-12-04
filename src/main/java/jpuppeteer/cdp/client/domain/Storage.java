package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Storage {

    private jpuppeteer.cdp.CDPConnection connection;

    public Storage(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Clears storage for origin.
    */
    public io.netty.util.concurrent.Future clearDataForOrigin(jpuppeteer.cdp.client.entity.storage.ClearDataForOriginRequest request) {
        return connection.send("Storage.clearDataForOrigin", request);
    }


    /**
    * Returns all browser cookies.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.storage.GetCookiesResponse> getCookies(jpuppeteer.cdp.client.entity.storage.GetCookiesRequest request) {
        return connection.send("Storage.getCookies", request, jpuppeteer.cdp.client.entity.storage.GetCookiesResponse.class);
    }


    /**
    * Sets given cookies.
    */
    public io.netty.util.concurrent.Future setCookies(jpuppeteer.cdp.client.entity.storage.SetCookiesRequest request) {
        return connection.send("Storage.setCookies", request);
    }


    /**
    * Clears cookies.
    */
    public io.netty.util.concurrent.Future clearCookies(jpuppeteer.cdp.client.entity.storage.ClearCookiesRequest request) {
        return connection.send("Storage.clearCookies", request);
    }


    /**
    * Returns usage and quota in bytes.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.storage.GetUsageAndQuotaResponse> getUsageAndQuota(jpuppeteer.cdp.client.entity.storage.GetUsageAndQuotaRequest request) {
        return connection.send("Storage.getUsageAndQuota", request, jpuppeteer.cdp.client.entity.storage.GetUsageAndQuotaResponse.class);
    }


    /**
    * Registers origin to be notified when an update occurs to its cache storage list.
    */
    public io.netty.util.concurrent.Future trackCacheStorageForOrigin(jpuppeteer.cdp.client.entity.storage.TrackCacheStorageForOriginRequest request) {
        return connection.send("Storage.trackCacheStorageForOrigin", request);
    }


    /**
    * Registers origin to be notified when an update occurs to its IndexedDB.
    */
    public io.netty.util.concurrent.Future trackIndexedDBForOrigin(jpuppeteer.cdp.client.entity.storage.TrackIndexedDBForOriginRequest request) {
        return connection.send("Storage.trackIndexedDBForOrigin", request);
    }


    /**
    * Unregisters origin from receiving notifications for cache storage.
    */
    public io.netty.util.concurrent.Future untrackCacheStorageForOrigin(jpuppeteer.cdp.client.entity.storage.UntrackCacheStorageForOriginRequest request) {
        return connection.send("Storage.untrackCacheStorageForOrigin", request);
    }


    /**
    * Unregisters origin from receiving notifications for IndexedDB.
    */
    public io.netty.util.concurrent.Future untrackIndexedDBForOrigin(jpuppeteer.cdp.client.entity.storage.UntrackIndexedDBForOriginRequest request) {
        return connection.send("Storage.untrackIndexedDBForOrigin", request);
    }

}