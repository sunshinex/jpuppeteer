package jpuppeteer.cdp.client.entity.network;

/**
* Fired when handling requests for resources within a .wbn file. Note: this will only be fired for resources that are requested by the webpage.
*/
public class SubresourceWebBundleInnerResponseParsedEvent {

    /**
    * Request identifier of the subresource request
    */
    public final String innerRequestId;

    /**
    * URL of the subresource resource.
    */
    public final String innerRequestURL;

    /**
    * Bundle request identifier. Used to match this information to another event. This made be absent in case when the instrumentation was enabled only after webbundle was parsed.
    */
    public final String bundleRequestId;

    public SubresourceWebBundleInnerResponseParsedEvent(String innerRequestId, String innerRequestURL, String bundleRequestId) {
        this.innerRequestId = innerRequestId;
        this.innerRequestURL = innerRequestURL;
        this.bundleRequestId = bundleRequestId;
    }

    public SubresourceWebBundleInnerResponseParsedEvent(String innerRequestId, String innerRequestURL) {
        this.innerRequestId = innerRequestId;
        this.innerRequestURL = innerRequestURL;
        this.bundleRequestId = null;
    }

}