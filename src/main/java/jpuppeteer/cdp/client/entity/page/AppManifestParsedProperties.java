package jpuppeteer.cdp.client.entity.page;

/**
* Parsed app manifest properties.
*/
public class AppManifestParsedProperties {

    /**
    * Computed scope value
    */
    private String scope;

    public void setScope (String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return this.scope;
    }

    public AppManifestParsedProperties(String scope) {
        this.scope = scope;
    }

    public AppManifestParsedProperties() {
    }

}