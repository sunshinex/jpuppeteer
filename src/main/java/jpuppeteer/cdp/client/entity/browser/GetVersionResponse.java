package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetVersionResponse {

    /**
    * Protocol version.
    */
    private String protocolVersion;

    /**
    * Product name.
    */
    private String product;

    /**
    * Product revision.
    */
    private String revision;

    /**
    * User-Agent.
    */
    private String userAgent;

    /**
    * V8 version.
    */
    private String jsVersion;

    public void setProtocolVersion (String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getProtocolVersion() {
        return this.protocolVersion;
    }

    public void setProduct (String product) {
        this.product = product;
    }

    public String getProduct() {
        return this.product;
    }

    public void setRevision (String revision) {
        this.revision = revision;
    }

    public String getRevision() {
        return this.revision;
    }

    public void setUserAgent (String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setJsVersion (String jsVersion) {
        this.jsVersion = jsVersion;
    }

    public String getJsVersion() {
        return this.jsVersion;
    }

    public GetVersionResponse(String protocolVersion, String product, String revision, String userAgent, String jsVersion) {
        this.protocolVersion = protocolVersion;
        this.product = product;
        this.revision = revision;
        this.userAgent = userAgent;
        this.jsVersion = jsVersion;
    }

    public GetVersionResponse() {
    }

}