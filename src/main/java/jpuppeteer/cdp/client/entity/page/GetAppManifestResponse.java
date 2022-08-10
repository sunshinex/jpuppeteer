package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetAppManifestResponse {

    /**
    * Manifest location.
    */
    private String url;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.AppManifestError> errors;

    /**
    * Manifest content.
    */
    private String data;

    /**
    * Parsed manifest properties
    */
    private jpuppeteer.cdp.client.entity.page.AppManifestParsedProperties parsed;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setErrors (java.util.List<jpuppeteer.cdp.client.entity.page.AppManifestError> errors) {
        this.errors = errors;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.AppManifestError> getErrors() {
        return this.errors;
    }

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setParsed (jpuppeteer.cdp.client.entity.page.AppManifestParsedProperties parsed) {
        this.parsed = parsed;
    }

    public jpuppeteer.cdp.client.entity.page.AppManifestParsedProperties getParsed() {
        return this.parsed;
    }

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

    public GetAppManifestResponse() {
    }

}