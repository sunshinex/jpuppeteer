package jpuppeteer.cdp.client.entity.network;

/**
* Fired once when parsing the .wbn file has failed.
*/
public class SubresourceWebBundleMetadataErrorEvent {

    /**
    * Request identifier. Used to match this information to another event.
    */
    public final String requestId;

    /**
    * Error message
    */
    public final String errorMessage;

    public SubresourceWebBundleMetadataErrorEvent(String requestId, String errorMessage) {
        this.requestId = requestId;
        this.errorMessage = errorMessage;
    }

}