package jpuppeteer.cdp.client.entity.target;

/**
*/
public class SetDiscoverTargetsRequest {

    /**
    * Whether to discover available targets.
    */
    private Boolean discover;

    public void setDiscover (Boolean discover) {
        this.discover = discover;
    }

    public Boolean getDiscover() {
        return this.discover;
    }

    public SetDiscoverTargetsRequest(Boolean discover) {
        this.discover = discover;
    }

    public SetDiscoverTargetsRequest() {
    }

}