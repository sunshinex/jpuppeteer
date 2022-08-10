package jpuppeteer.cdp.client.entity.network;

/**
* Fired once when parsing the .wbn file has failed.
*/
public class SubresourceWebBundleMetadataErrorEvent {

    /**
    * Request identifier. Used to match this information to another event.
    */
    private String requestId;

    /**
    * Error message
    */
    private String errorMessage;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public SubresourceWebBundleMetadataErrorEvent(String requestId, String errorMessage) {
        this.requestId = requestId;
        this.errorMessage = errorMessage;
    }

    public SubresourceWebBundleMetadataErrorEvent() {
    }

}