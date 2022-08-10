package jpuppeteer.cdp.client.entity.network;

/**
* Information about the cached resource.
*/
public class CachedResource {

    /**
    * Resource URL. This is the url of the original network request.
    */
    private String url;

    /**
    * Type of this resource.
    */
    private jpuppeteer.cdp.client.constant.network.ResourceType type;

    /**
    * Cached response data.
    */
    private jpuppeteer.cdp.client.entity.network.Response response;

    /**
    * Cached response body size.
    */
    private java.math.BigDecimal bodySize;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setType (jpuppeteer.cdp.client.constant.network.ResourceType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.network.ResourceType getType() {
        return this.type;
    }

    public void setResponse (jpuppeteer.cdp.client.entity.network.Response response) {
        this.response = response;
    }

    public jpuppeteer.cdp.client.entity.network.Response getResponse() {
        return this.response;
    }

    public void setBodySize (java.math.BigDecimal bodySize) {
        this.bodySize = bodySize;
    }

    public java.math.BigDecimal getBodySize() {
        return this.bodySize;
    }

    public CachedResource(String url, jpuppeteer.cdp.client.constant.network.ResourceType type, jpuppeteer.cdp.client.entity.network.Response response, java.math.BigDecimal bodySize) {
        this.url = url;
        this.type = type;
        this.response = response;
        this.bodySize = bodySize;
    }

    public CachedResource(String url, jpuppeteer.cdp.client.constant.network.ResourceType type, java.math.BigDecimal bodySize) {
        this.url = url;
        this.type = type;
        this.response = null;
        this.bodySize = bodySize;
    }

    public CachedResource() {
    }

}