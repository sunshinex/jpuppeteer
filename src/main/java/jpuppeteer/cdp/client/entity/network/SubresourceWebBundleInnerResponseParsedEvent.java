package jpuppeteer.cdp.client.entity.network;

/**
* Fired when handling requests for resources within a .wbn file. Note: this will only be fired for resources that are requested by the webpage.
*/
public class SubresourceWebBundleInnerResponseParsedEvent {

    /**
    * Request identifier of the subresource request
    */
    private String innerRequestId;

    /**
    * URL of the subresource resource.
    */
    private String innerRequestURL;

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

    public void setBundleRequestId (String bundleRequestId) {
        this.bundleRequestId = bundleRequestId;
    }

    public String getBundleRequestId() {
        return this.bundleRequestId;
    }

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

    public SubresourceWebBundleInnerResponseParsedEvent() {
    }

}