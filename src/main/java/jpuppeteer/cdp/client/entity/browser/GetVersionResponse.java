package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetVersionResponse {

    /**
    * Protocol version.
    */
    public final String protocolVersion;

    /**
    * Product name.
    */
    public final String product;

    /**
    * Product revision.
    */
    public final String revision;

    /**
    * User-Agent.
    */
    public final String userAgent;

    /**
    * V8 version.
    */
    public final String jsVersion;

    public GetVersionResponse(String protocolVersion, String product, String revision, String userAgent, String jsVersion) {
        this.protocolVersion = protocolVersion;
        this.product = product;
        this.revision = revision;
        this.userAgent = userAgent;
        this.jsVersion = jsVersion;
    }

}