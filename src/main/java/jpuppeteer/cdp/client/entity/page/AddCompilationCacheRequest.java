package jpuppeteer.cdp.client.entity.page;

/**
*/
public class AddCompilationCacheRequest {

    /**
    */
    private String url;

    /**
    * Base64-encoded data (Encoded as a base64 string when passed over JSON)
    */
    private String data;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public AddCompilationCacheRequest(String url, String data) {
        this.url = url;
        this.data = data;
    }

    public AddCompilationCacheRequest() {
    }

}