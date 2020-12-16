package jpuppeteer.cdp.client.entity.cachestorage;

/**
* Cached response
* experimental
*/
public class CachedResponse {

    /**
    * Entry content, base64-encoded.
    */
    public final String body;

    public CachedResponse(String body) {
        this.body = body;
    }

}