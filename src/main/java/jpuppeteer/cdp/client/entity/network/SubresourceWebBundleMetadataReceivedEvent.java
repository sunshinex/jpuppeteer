package jpuppeteer.cdp.client.entity.network;

/**
* Fired once when parsing the .wbn file has succeeded. The event contains the information about the web bundle contents.
*/
public class SubresourceWebBundleMetadataReceivedEvent {

    /**
    * Request identifier. Used to match this information to another event.
    */
    public final String requestId;

    /**
    * A list of URLs of resources in the subresource Web Bundle.
    */
    public final java.util.List<String> urls;

    public SubresourceWebBundleMetadataReceivedEvent(String requestId, java.util.List<String> urls) {
        this.requestId = requestId;
        this.urls = urls;
    }

}