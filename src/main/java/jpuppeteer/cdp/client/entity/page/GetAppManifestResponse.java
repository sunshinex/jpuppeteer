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
    public final java.util.List<AppManifestError> errors;

    /**
    * Manifest content.
    */
    public final String data;

    /**
    * Parsed manifest properties
    */
    public final AppManifestParsedProperties parsed;

    public GetAppManifestResponse(String url, java.util.List<AppManifestError> errors, String data, AppManifestParsedProperties parsed) {
        this.url = url;
        this.errors = errors;
        this.data = data;
        this.parsed = parsed;
    }

    public GetAppManifestResponse(String url, java.util.List<AppManifestError> errors) {
        this.url = url;
        this.errors = errors;
        this.data = null;
        this.parsed = null;
    }

}