package jpuppeteer.cdp.client.entity.network;

/**
* A cookie which was not stored from a response with the corresponding reason.
*/
public class BlockedSetCookieWithReason {

    /**
    * The reason(s) this cookie was blocked.
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.network.SetCookieBlockedReason> blockedReasons;

    /**
    * The string representing this individual cookie as it would appear in the header. This is not the entire "cookie" or "set-cookie" header which could have multiple cookies.
    */
    public final String cookieLine;

    /**
    * The cookie object which represents the cookie which was not stored. It is optional because sometimes complete cookie information is not available, such as in the case of parsing errors.
    */
    public final jpuppeteer.cdp.client.entity.network.Cookie cookie;

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

}