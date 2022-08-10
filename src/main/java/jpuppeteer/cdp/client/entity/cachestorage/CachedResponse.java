package jpuppeteer.cdp.client.entity.cachestorage;

/**
* Cached response
* experimental
*/
public class CachedResponse {

    /**
    * Entry content, base64-encoded. (Encoded as a base64 string when passed over JSON)
    */
    private String body;

    public void setBody (String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

    public CachedResponse(String body) {
        this.body = body;
    }

    public CachedResponse() {
    }

}