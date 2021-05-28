package jpuppeteer.cdp.client.entity.page;

/**
*/
public class AddCompilationCacheRequest {

    /**
    */
    public final String url;

    /**
    * Base64-encoded data (Encoded as a base64 string when passed over JSON)
    */
    public final String data;

    public AddCompilationCacheRequest(String url, String data) {
        this.url = url;
        this.data = data;
    }

}