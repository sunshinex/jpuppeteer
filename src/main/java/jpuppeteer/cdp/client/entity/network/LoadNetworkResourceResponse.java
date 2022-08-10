package jpuppeteer.cdp.client.entity.network;

/**
*/
public class LoadNetworkResourceResponse {

    /**
    */
    private jpuppeteer.cdp.client.entity.network.LoadNetworkResourcePageResult resource;

    public void setResource (jpuppeteer.cdp.client.entity.network.LoadNetworkResourcePageResult resource) {
        this.resource = resource;
    }

    public jpuppeteer.cdp.client.entity.network.LoadNetworkResourcePageResult getResource() {
        return this.resource;
    }

    public LoadNetworkResourceResponse(jpuppeteer.cdp.client.entity.network.LoadNetworkResourcePageResult resource) {
        this.resource = resource;
    }

    public LoadNetworkResourceResponse() {
    }

}