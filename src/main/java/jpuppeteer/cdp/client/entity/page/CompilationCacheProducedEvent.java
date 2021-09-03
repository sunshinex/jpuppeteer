package jpuppeteer.cdp.client.entity.page;

/**
* Issued for every compilation cache generated. Is only available if Page.setGenerateCompilationCache is enabled.
*/
public class CompilationCacheProducedEvent {

    /**
    */
    public final String url;

    /**
    * Base64-encoded data (Encoded as a base64 string when passed over JSON)
    */
    public final String data;

    public CompilationCacheProducedEvent(String url, String data) {
        this.url = url;
        this.data = data;
    }

}