package jpuppeteer.cdp.client.entity.target;

/**
*/
public class SetDiscoverTargetsRequest {

    /**
    * Whether to discover available targets.
    */
    public final Boolean discover;

    public SetDiscoverTargetsRequest(Boolean discover) {
        this.discover = discover;
    }

}