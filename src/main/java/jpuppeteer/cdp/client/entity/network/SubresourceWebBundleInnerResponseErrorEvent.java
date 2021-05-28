package jpuppeteer.cdp.client.entity.network;

/**
* Fired when request for resources within a .wbn file failed.
*/
public class SubresourceWebBundleInnerResponseErrorEvent {

    /**
    * Request identifier of the subresource request
    */
    public final String innerRequestId;

    /**
    * URL of the subresource resource.
    */
    public final String innerRequestURL;

    /**
    * Error message
    */
    public final String errorMessage;

    /**
    * Bundle request identifier. Used to match this information to another event. This made be absent in case when the instrumentation was enabled only after webbundle was parsed.
    */
    public final String bundleRequestId;

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

}