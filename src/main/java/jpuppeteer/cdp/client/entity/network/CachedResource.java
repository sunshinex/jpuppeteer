package jpuppeteer.cdp.client.entity.network;

/**
* Information about the cached resource.
*/
public class CachedResource {

    /**
    * Resource URL. This is the url of the original network request.
    */
    public final String url;

    /**
    * Type of this resource.
    */
    public final String type;

    /**
    * Cached response data.
    */
    public final jpuppeteer.cdp.client.entity.network.Response response;

    /**
    * Cached response body size.
    */
    public final java.math.BigDecimal bodySize;

    public CachedResource(String url, String type, jpuppeteer.cdp.client.entity.network.Response response, java.math.BigDecimal bodySize) {
        this.url = url;
        this.type = type;
        this.response = response;
        this.bodySize = bodySize;
    }

    public CachedResource(String url, String type, java.math.BigDecimal bodySize) {
        this.url = url;
        this.type = type;
        this.response = null;
        this.bodySize = bodySize;
    }

}