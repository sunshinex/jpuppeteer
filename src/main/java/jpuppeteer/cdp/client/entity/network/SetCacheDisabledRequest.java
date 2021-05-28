package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCacheDisabledRequest {

    /**
    * Cache disabled state.
    */
    public final Boolean cacheDisabled;

    public SetCacheDisabledRequest(Boolean cacheDisabled) {
        this.cacheDisabled = cacheDisabled;
    }

}