package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCacheDisabledRequest {

    /**
    * Cache disabled state.
    */
    private Boolean cacheDisabled;

    public void setCacheDisabled (Boolean cacheDisabled) {
        this.cacheDisabled = cacheDisabled;
    }

    public Boolean getCacheDisabled() {
        return this.cacheDisabled;
    }

    public SetCacheDisabledRequest(Boolean cacheDisabled) {
        this.cacheDisabled = cacheDisabled;
    }

    public SetCacheDisabledRequest() {
    }

}