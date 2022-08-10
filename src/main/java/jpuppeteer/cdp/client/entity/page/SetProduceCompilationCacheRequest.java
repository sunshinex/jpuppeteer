package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetProduceCompilationCacheRequest {

    /**
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetProduceCompilationCacheRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetProduceCompilationCacheRequest() {
    }

}