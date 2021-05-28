package jpuppeteer.cdp.client.entity.emulation;

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

    /**
    * To be sent in Sec-CH-UA-* headers and returned in navigator.userAgentData
    */
    public final jpuppeteer.cdp.client.entity.emulation.UserAgentMetadata userAgentMetadata;

    public SetUserAgentOverrideRequest(String userAgent, String acceptLanguage, String platform, jpuppeteer.cdp.client.entity.emulation.UserAgentMetadata userAgentMetadata) {
        this.userAgent = userAgent;
        this.acceptLanguage = acceptLanguage;
        this.platform = platform;
        this.userAgentMetadata = userAgentMetadata;
    }

    public SetUserAgentOverrideRequest(String userAgent) {
        this.userAgent = userAgent;
        this.acceptLanguage = null;
        this.platform = null;
        this.userAgentMetadata = null;
    }

}