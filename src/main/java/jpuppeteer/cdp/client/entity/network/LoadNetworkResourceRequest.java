package jpuppeteer.cdp.client.entity.network;

/**
*/
public class LoadNetworkResourceRequest {

    /**
    * Frame id to get the resource for.
    */
    public final String frameId;

    /**
    * URL of the resource to get content for.
    */
    public final String url;

    /**
    * Options for the request.
    */
    public final jpuppeteer.cdp.client.entity.network.LoadNetworkResourceOptions options;

    public LoadNetworkResourceRequest(String frameId, String url, jpuppeteer.cdp.client.entity.network.LoadNetworkResourceOptions options) {
        this.frameId = frameId;
        this.url = url;
        this.options = options;
    }

}