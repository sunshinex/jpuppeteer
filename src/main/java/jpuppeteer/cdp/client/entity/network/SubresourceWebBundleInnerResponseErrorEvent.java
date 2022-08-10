package jpuppeteer.cdp.client.entity.network;

/**
* Fired when request for resources within a .wbn file failed.
*/
public class SubresourceWebBundleInnerResponseErrorEvent {

    /**
    * Request identifier of the subresource request
    */
    private String innerRequestId;

    /**
    * URL of the subresource resource.
    */
    private String innerRequestURL;

    /**
    * Error message
    */
    private String errorMessage;

    /**
    * Bundle request identifier. Used to match this information to another event. This made be absent in case when the instrumentation was enabled only after webbundle was parsed.
    */
    private String bundleRequestId;

    public void setInnerRequestId (String innerRequestId) {
        this.innerRequestId = innerRequestId;
    }

    public String getInnerRequestId() {
        return this.innerRequestId;
    }

    public void setInnerRequestURL (String innerRequestURL) {
        this.innerRequestURL = innerRequestURL;
    }

    public String getInnerRequestURL() {
        return this.innerRequestURL;
    }

    public void setErrorMessage (String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setBundleRequestId (String bundleRequestId) {
        this.bundleRequestId = bundleRequestId;
    }

    public String getBundleRequestId() {
        return this.bundleRequestId;
    }

    public SubresourceWebBundleInnerResponseErrorEvent(String innerRequestId, String innerRequestURL, String errorMessage, String bundleRequestId) {
        this.innerRequestId = innerRequestId;
        this.innerRequestURL = innerRequestURL;
        this.errorMessage = errorMessage;
        this.bundleRequestId = bundleRequestId;
    }

    public SubresourceWebBundleInnerResponseErrorEvent(String innerRequestId, String innerRequestURL, String errorMessage) {
        this.innerRequestId = innerRequestId;
        this.innerRequestURL = innerRequestURL;
        this.errorMessage = errorMessage;
        this.bundleRequestId = null;
    }

    public SubresourceWebBundleInnerResponseErrorEvent() {
    }

}