package jpuppeteer.cdp.client.entity.network;

/**
* Cookie parameter object
*/
public class CookieParam {

    /**
    * Cookie name.
    */
    private String name;

    /**
    * Cookie value.
    */
    private String value;

    /**
    * The request-URI to associate with the setting of the cookie. This value can affect the default domain, path, source port, and source scheme values of the created cookie.
    */
    private String url;

    /**
    * Cookie domain.
    */
    private String domain;

    /**
    * Cookie path.
    */
    private String path;

    /**
    * True if cookie is secure.
    */
    private Boolean secure;

    /**
    * True if cookie is http-only.
    */
    private Boolean httpOnly;

    /**
    * Cookie SameSite type.
    */
    private jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite;

    /**
    * Cookie expiration date, session cookie if not set
    */
    private java.math.BigDecimal expires;

    /**
    * Cookie Priority.
    */
    private jpuppeteer.cdp.client.constant.network.CookiePriority priority;

    /**
    * True if cookie is SameParty.
    */
    private Boolean sameParty;

    /**
    * Cookie source scheme type.
    */
    private jpuppeteer.cdp.client.constant.network.CookieSourceScheme sourceScheme;

    /**
    * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port. An unspecified port value allows protocol clients to emulate legacy cookie scope for the port. This is a temporary ability and it will be removed in the future.
    */
    private Integer sourcePort;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDomain (String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setPath (String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void setSecure (Boolean secure) {
        this.secure = secure;
    }

    public Boolean getSecure() {
        return this.secure;
    }

    public void setHttpOnly (Boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public Boolean getHttpOnly() {
        return this.httpOnly;
    }

    public void setSameSite (jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite) {
        this.sameSite = sameSite;
    }

    public jpuppeteer.cdp.client.constant.network.CookieSameSite getSameSite() {
        return this.sameSite;
    }

    public void setExpires (java.math.BigDecimal expires) {
        this.expires = expires;
    }

    public java.math.BigDecimal getExpires() {
        return this.expires;
    }

    public void setPriority (jpuppeteer.cdp.client.constant.network.CookiePriority priority) {
        this.priority = priority;
    }

    public jpuppeteer.cdp.client.constant.network.CookiePriority getPriority() {
        return this.priority;
    }

    public void setSameParty (Boolean sameParty) {
        this.sameParty = sameParty;
    }

    public Boolean getSameParty() {
        return this.sameParty;
    }

    public void setSourceScheme (jpuppeteer.cdp.client.constant.network.CookieSourceScheme sourceScheme) {
        this.sourceScheme = sourceScheme;
    }

    public jpuppeteer.cdp.client.constant.network.CookieSourceScheme getSourceScheme() {
        return this.sourceScheme;
    }

    public void setSourcePort (Integer sourcePort) {
        this.sourcePort = sourcePort;
    }

    public Integer getSourcePort() {
        return this.sourcePort;
    }

    public CookieParam(String name, String value, String url, String domain, String path, Boolean secure, Boolean httpOnly, jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite, java.math.BigDecimal expires, jpuppeteer.cdp.client.constant.network.CookiePriority priority, Boolean sameParty, jpuppeteer.cdp.client.constant.network.CookieSourceScheme sourceScheme, Integer sourcePort) {
        this.name = name;
        this.value = value;
        this.url = url;
        this.domain = domain;
        this.path = path;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.sameSite = sameSite;
        this.expires = expires;
        this.priority = priority;
        this.sameParty = sameParty;
        this.sourceScheme = sourceScheme;
        this.sourcePort = sourcePort;
    }

    public CookieParam(String name, String value) {
        this.name = name;
        this.value = value;
        this.url = null;
        this.domain = null;
        this.path = null;
        this.secure = null;
        this.httpOnly = null;
        this.sameSite = null;
        this.expires = null;
        this.priority = null;
        this.sameParty = null;
        this.sourceScheme = null;
        this.sourcePort = null;
    }

    public CookieParam() {
    }

}