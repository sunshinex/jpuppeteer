package jpuppeteer.cdp.client.entity.network;

/**
* An options object that may be extended later to better support CORS, CORB and streaming.
*/
public class LoadNetworkResourceOptions {

    /**
    */
    private Boolean disableCache;

    /**
    */
    private Boolean includeCredentials;

    public void setDisableCache (Boolean disableCache) {
        this.disableCache = disableCache;
    }

    public Boolean getDisableCache() {
        return this.disableCache;
    }

    public void setIncludeCredentials (Boolean includeCredentials) {
        this.includeCredentials = includeCredentials;
    }

    public Boolean getIncludeCredentials() {
        return this.includeCredentials;
    }

    public LoadNetworkResourceOptions(Boolean disableCache, Boolean includeCredentials) {
        this.disableCache = disableCache;
        this.includeCredentials = includeCredentials;
    }

    public LoadNetworkResourceOptions() {
    }

}