package jpuppeteer.cdp.client.entity.network;

/**
* An options object that may be extended later to better support CORS, CORB and streaming.
*/
public class LoadNetworkResourceOptions {

    /**
    */
    public final Boolean disableCache;

    /**
    */
    public final Boolean includeCredentials;

    public LoadNetworkResourceOptions(Boolean disableCache, Boolean includeCredentials) {
        this.disableCache = disableCache;
        this.includeCredentials = includeCredentials;
    }

}