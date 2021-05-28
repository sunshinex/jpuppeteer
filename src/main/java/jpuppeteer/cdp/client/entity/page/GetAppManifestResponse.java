package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetAppManifestResponse {

    /**
    * Manifest location.
    */
    public final String url;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.page.AppManifestError> errors;

    /**
    * Manifest content.
    */
    public final String data;

    /**
    * Parsed manifest properties
    */
    public final jpuppeteer.cdp.client.entity.page.AppManifestParsedProperties parsed;

    public GetAppManifestResponse(String url, java.util.List<jpuppeteer.cdp.client.entity.page.AppManifestError> errors, String data, jpuppeteer.cdp.client.entity.page.AppManifestParsedProperties parsed) {
        this.url = url;
        this.errors = errors;
        this.data = data;
        this.parsed = parsed;
    }

    public GetAppManifestResponse(String url, java.util.List<jpuppeteer.cdp.client.entity.page.AppManifestError> errors) {
        this.url = url;
        this.errors = errors;
        this.data = null;
        this.parsed = null;
    }

}