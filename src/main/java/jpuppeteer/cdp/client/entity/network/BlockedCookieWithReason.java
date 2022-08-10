package jpuppeteer.cdp.client.entity.network;

/**
* A cookie with was not sent with a request with the corresponding reason.
*/
public class BlockedCookieWithReason {

    /**
    * The reason(s) the cookie was blocked.
    */
    private java.util.List<jpuppeteer.cdp.client.constant.network.CookieBlockedReason> blockedReasons;

    /**
    * The cookie object representing the cookie which was not sent.
    */
    private jpuppeteer.cdp.client.entity.network.Cookie cookie;

    public void setBlockedReasons (java.util.List<jpuppeteer.cdp.client.constant.network.CookieBlockedReason> blockedReasons) {
        this.blockedReasons = blockedReasons;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.network.CookieBlockedReason> getBlockedReasons() {
        return this.blockedReasons;
    }

    public void setCookie (jpuppeteer.cdp.client.entity.network.Cookie cookie) {
        this.cookie = cookie;
    }

    public jpuppeteer.cdp.client.entity.network.Cookie getCookie() {
        return this.cookie;
    }

    public BlockedCookieWithReason(java.util.List<jpuppeteer.cdp.client.constant.network.CookieBlockedReason> blockedReasons, jpuppeteer.cdp.client.entity.network.Cookie cookie) {
        this.blockedReasons = blockedReasons;
        this.cookie = cookie;
    }

    public BlockedCookieWithReason() {
    }

}