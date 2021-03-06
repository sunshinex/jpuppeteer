package jpuppeteer.cdp.client.entity.network;

/**
* A cookie with was not sent with a request with the corresponding reason.
*/
public class BlockedCookieWithReason {

    /**
    * The reason(s) the cookie was blocked.
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.network.CookieBlockedReason> blockedReasons;

    /**
    * The cookie object representing the cookie which was not sent.
    */
    public final Cookie cookie;

    public BlockedCookieWithReason(java.util.List<jpuppeteer.cdp.client.constant.network.CookieBlockedReason> blockedReasons, Cookie cookie) {
        this.blockedReasons = blockedReasons;
        this.cookie = cookie;
    }

}