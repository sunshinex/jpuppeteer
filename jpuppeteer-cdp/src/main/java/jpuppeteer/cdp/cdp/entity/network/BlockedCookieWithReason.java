package jpuppeteer.cdp.cdp.entity.network;

/**
* A cookie with was not sent with a request with the corresponding reason.
*/
@lombok.Setter
@lombok.Getter
@lombok.ToString
public class BlockedCookieWithReason {

    /**
    * The reason the cookie was blocked.
    */
    private String blockedReason;

    /**
    * The cookie object representing the cookie which was not sent.
    */
    private jpuppeteer.cdp.cdp.entity.network.Cookie cookie;



}