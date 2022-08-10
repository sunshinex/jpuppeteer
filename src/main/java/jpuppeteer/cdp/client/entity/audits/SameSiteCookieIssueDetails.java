package jpuppeteer.cdp.client.entity.audits;

/**
* This information is currently necessary, as the front-end has a difficult time finding a specific cookie. With this, we can convey specific error information without the cookie.
* experimental
*/
public class SameSiteCookieIssueDetails {

    /**
    * If AffectedCookie is not set then rawCookieLine contains the raw Set-Cookie header string. This hints at a problem where the cookie line is syntactically or semantically malformed in a way that no valid cookie could be created.
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedCookie cookie;

    /**
    */
    private String rawCookieLine;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieWarningReason> cookieWarningReasons;

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieExclusionReason> cookieExclusionReasons;

    /**
    * Optionally identifies the site-for-cookies and the cookie url, which may be used by the front-end as additional context.
    */
    private jpuppeteer.cdp.client.constant.audits.SameSiteCookieOperation operation;

    /**
    */
    private String siteForCookies;

    /**
    */
    private String cookieUrl;

    /**
    */
    private jpuppeteer.cdp.client.entity.audits.AffectedRequest request;

    public void setCookie (jpuppeteer.cdp.client.entity.audits.AffectedCookie cookie) {
        this.cookie = cookie;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedCookie getCookie() {
        return this.cookie;
    }

    public void setRawCookieLine (String rawCookieLine) {
        this.rawCookieLine = rawCookieLine;
    }

    public String getRawCookieLine() {
        return this.rawCookieLine;
    }

    public void setCookieWarningReasons (java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieWarningReason> cookieWarningReasons) {
        this.cookieWarningReasons = cookieWarningReasons;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieWarningReason> getCookieWarningReasons() {
        return this.cookieWarningReasons;
    }

    public void setCookieExclusionReasons (java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieExclusionReason> cookieExclusionReasons) {
        this.cookieExclusionReasons = cookieExclusionReasons;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.audits.SameSiteCookieExclusionReason> getCookieExclusionReasons() {
        return this.cookieExclusionReasons;
    }

    public void setOperation (jpuppeteer.cdp.client.constant.audits.SameSiteCookieOperation operation) {
        this.operation = operation;
    }

    public jpuppeteer.cdp.client.constant.audits.SameSiteCookieOperation getOperation() {
        return this.operation;
    }

    public void setSiteForCookies (String siteForCookies) {
        this.siteForCookies = siteForCookies;
    }

    public String getSiteForCookies() {
        return this.siteForCookies;
    }

    public void setCookieUrl (String cookieUrl) {
        this.cookieUrl = cookieUrl;
    }

    public String getCookieUrl() {
        return this.cookieUrl;
    }

    public void setRequest (jpuppeteer.cdp.client.entity.audits.AffectedRequest request) {
        this.request = request;
    }

    public jpuppeteer.cdp.client.entity.audits.AffectedRequest getRequest() {
        return this.request;
    }

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

    public SameSiteCookieIssueDetails() {
    }

}