package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetUserAgentOverrideRequest {

    /**
    * User agent to use.
    */
    private String userAgent;

    /**
    * Browser langugage to emulate.
    */
    private String acceptLanguage;

    /**
    * The platform navigator.platform should return.
    */
    private String platform;

    /**
    * To be sent in Sec-CH-UA-* headers and returned in navigator.userAgentData
    */
    private jpuppeteer.cdp.client.entity.emulation.UserAgentMetadata userAgentMetadata;

    public void setUserAgent (String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setAcceptLanguage (String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public String getAcceptLanguage() {
        return this.acceptLanguage;
    }

    public void setPlatform (String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setUserAgentMetadata (jpuppeteer.cdp.client.entity.emulation.UserAgentMetadata userAgentMetadata) {
        this.userAgentMetadata = userAgentMetadata;
    }

    public jpuppeteer.cdp.client.entity.emulation.UserAgentMetadata getUserAgentMetadata() {
        return this.userAgentMetadata;
    }

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

    public SetUserAgentOverrideRequest() {
    }

}