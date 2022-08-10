package jpuppeteer.cdp.client.entity.network;

/**
*/
public class LoadNetworkResourceRequest {

    /**
    * Frame id to get the resource for.
    */
    private String frameId;

    /**
    * URL of the resource to get content for.
    */
    private String url;

    /**
    * Options for the request.
    */
    private jpuppeteer.cdp.client.entity.network.LoadNetworkResourceOptions options;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setOptions (jpuppeteer.cdp.client.entity.network.LoadNetworkResourceOptions options) {
        this.options = options;
    }

    public jpuppeteer.cdp.client.entity.network.LoadNetworkResourceOptions getOptions() {
        return this.options;
    }

    public LoadNetworkResourceRequest(String frameId, String url, jpuppeteer.cdp.client.entity.network.LoadNetworkResourceOptions options) {
        this.frameId = frameId;
        this.url = url;
        this.options = options;
    }

    public LoadNetworkResourceRequest() {
    }

}