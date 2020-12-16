package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetUserAgentOverrideRequest {

    /**
    * User agent to use.
    */
    public final String userAgent;

    /**
    * Browser langugage to emulate.
    */
    public final String acceptLanguage;

    /**
    * The platform navigator.platform should return.
    */
    public final String platform;

    public SetUserAgentOverrideRequest(String userAgent, String acceptLanguage, String platform) {
        this.userAgent = userAgent;
        this.acceptLanguage = acceptLanguage;
        this.platform = platform;
    }

    public SetUserAgentOverrideRequest(String userAgent) {
        this.userAgent = userAgent;
        this.acceptLanguage = null;
        this.platform = null;
    }

}