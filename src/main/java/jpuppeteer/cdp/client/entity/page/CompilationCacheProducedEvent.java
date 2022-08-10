package jpuppeteer.cdp.client.entity.page;

/**
* Issued for every compilation cache generated. Is only available if Page.setGenerateCompilationCache is enabled.
*/
public class CompilationCacheProducedEvent {

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

    public CompilationCacheProducedEvent(String url, String data) {
        this.url = url;
        this.data = data;
    }

    public CompilationCacheProducedEvent() {
    }

}