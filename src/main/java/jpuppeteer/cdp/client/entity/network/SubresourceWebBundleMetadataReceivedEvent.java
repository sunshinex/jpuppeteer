package jpuppeteer.cdp.client.entity.network;

/**
* Fired once when parsing the .wbn file has succeeded. The event contains the information about the web bundle contents.
*/
public class SubresourceWebBundleMetadataReceivedEvent {

    /**
    * Request identifier. Used to match this information to another event.
    */
    private String requestId;

    /**
    * A list of URLs of resources in the subresource Web Bundle.
    */
    private java.util.List<String> urls;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setUrls (java.util.List<String> urls) {
        this.urls = urls;
    }

    public java.util.List<String> getUrls() {
        return this.urls;
    }

    public SubresourceWebBundleMetadataReceivedEvent(String requestId, java.util.List<String> urls) {
        this.requestId = requestId;
        this.urls = urls;
    }

    public SubresourceWebBundleMetadataReceivedEvent() {
    }

}