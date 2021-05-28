package jpuppeteer.cdp.client.entity.audits;

/**
* This information is currently necessary, as the front-end has a difficult time finding a specific cookie. With this, we can convey specific error information without the cookie.
* experimental
*/
public class SameSiteCookieIssueDetails {

    /**
    * If AffectedCookie is not set then rawCookieLine contains the raw Set-Cookie header string. This hints at a problem where the cookie line is syntactically or semantically malformed in a way that no valid cookie could be created.
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedCookie cookie;

    /**
    */
    public final String rawCookieLine;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieWarningReason> cookieWarningReasons;

    /**
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieExclusionReason> cookieExclusionReasons;

    /**
    * Optionally identifies the site-for-cookies and the cookie url, which may be used by the front-end as additional context.
    */
    public final jpuppeteer.cdp.client.constant.audits.SameSiteCookieOperation operation;

    /**
    */
    public final String siteForCookies;

    /**
    */
    public final String cookieUrl;

    /**
    */
    public final jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    public SameSiteCookieIssueDetails(jpuppeteer.cdp.client.entity.audits.AffectedCookie cookie, String rawCookieLine, java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieWarningReason> cookieWarningReasons, java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieExclusionReason> cookieExclusionReasons, jpuppeteer.cdp.client.constant.audits.SameSiteCookieOperation operation, String siteForCookies, String cookieUrl, jpuppeteer.cdp.client.entity.audits.AffectedRequest request) {
        this.cookie = cookie;
        this.rawCookieLine = rawCookieLine;
        this.cookieWarningReasons = cookieWarningReasons;
        this.cookieExclusionReasons = cookieExclusionReasons;
        this.operation = operation;
        this.siteForCookies = siteForCookies;
        this.cookieUrl = cookieUrl;
        this.request = request;
    }

    public SameSiteCookieIssueDetails(java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieWarningReason> cookieWarningReasons, java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieExclusionReason> cookieExclusionReasons, jpuppeteer.cdp.client.constant.audits.SameSiteCookieOperation operation) {
        this.cookie = null;
        this.rawCookieLine = null;
        this.cookieWarningReasons = cookieWarningReasons;
        this.cookieExclusionReasons = cookieExclusionReasons;
        this.operation = operation;
        this.siteForCookies = null;
        this.cookieUrl = null;
        this.request = null;
    }

}