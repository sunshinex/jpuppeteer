package jpuppeteer.cdp.client.entity.network;

/**
* A cookie which was not stored from a response with the corresponding reason.
*/
public class BlockedSetCookieWithReason {

    /**
    * The reason(s) this cookie was blocked.
    */
    private java.util.List<jpuppeteer.cdp.client.constant.network.SetCookieBlockedReason> blockedReasons;

    /**
    * The string representing this individual cookie as it would appear in the header. This is not the entire "cookie" or "set-cookie" header which could have multiple cookies.
    */
    private String cookieLine;

    /**
    * The cookie object which represents the cookie which was not stored. It is optional because sometimes complete cookie information is not available, such as in the case of parsing errors.
    */
    private jpuppeteer.cdp.client.entity.network.Cookie cookie;

    public void setBlockedReasons (java.util.List<jpuppeteer.cdp.client.constant.network.SetCookieBlockedReason> blockedReasons) {
        this.blockedReasons = blockedReasons;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.network.SetCookieBlockedReason> getBlockedReasons() {
        return this.blockedReasons;
    }

    public void setCookieLine (String cookieLine) {
        this.cookieLine = cookieLine;
    }

    public String getCookieLine() {
        return this.cookieLine;
    }

    public void setCookie (jpuppeteer.cdp.client.entity.network.Cookie cookie) {
        this.cookie = cookie;
    }

    public jpuppeteer.cdp.client.entity.network.Cookie getCookie() {
        return this.cookie;
    }

    public BlockedSetCookieWithReason(java.util.List<jpuppeteer.cdp.client.constant.network.SetCookieBlockedReason> blockedReasons, String cookieLine, jpuppeteer.cdp.client.entity.network.Cookie cookie) {
        this.blockedReasons = blockedReasons;
        this.cookieLine = cookieLine;
        this.cookie = cookie;
    }

    public BlockedSetCookieWithReason(java.util.List<jpuppeteer.cdp.client.constant.network.SetCookieBlockedReason> blockedReasons, String cookieLine) {
        this.blockedReasons = blockedReasons;
        this.cookieLine = cookieLine;
        this.cookie = null;
    }

    public BlockedSetCookieWithReason() {
    }

}