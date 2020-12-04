package jpuppeteer.cdp.client.entity.network;

/**
* A cookie with was not sent with a request with the corresponding reason.
*/
public class BlockedCookieWithReason {

    /**
    * The reason(s) the cookie was blocked.
    */
    public final java.util.List<String> blockedReasons;

    /**
    * The cookie object representing the cookie which was not sent.
    */
    public final jpuppeteer.cdp.client.entity.network.Cookie cookie;

    public BlockedCookieWithReason(java.util.List<String> blockedReasons, jpuppeteer.cdp.client.entity.network.Cookie cookie) {
        this.blockedReasons = blockedReasons;
        this.cookie = cookie;
    }

}