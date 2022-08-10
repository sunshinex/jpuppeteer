package jpuppeteer.cdp.client.entity.network;

/**
* Cookie object
*/
public class Cookie {

    /**
    * Cookie name.
    */
    private String name;

    /**
    * Cookie value.
    */
    private String value;

    /**
    * Cookie domain.
    */
    private String domain;

    /**
    * Cookie path.
    */
    private String path;

    /**
    * Cookie expiration date as the number of seconds since the UNIX epoch.
    */
    private java.math.BigDecimal expires;

    /**
    * Cookie size.
    */
    private Integer size;

    /**
    * True if cookie is http-only.
    */
    private Boolean httpOnly;

    /**
    * True if cookie is secure.
    */
    private Boolean secure;

    /**
    * True in case of session cookie.
    */
    private Boolean session;

    /**
    * Cookie SameSite type.
    */
    private jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite;

    /**
    * Cookie Priority
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

    public void setExpires (java.math.BigDecimal expires) {
        this.expires = expires;
    }

    public java.math.BigDecimal getExpires() {
        return this.expires;
    }

    public void setSize (Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setHttpOnly (Boolean httpOnly) {
        this.httpOnly = httpOnly;
    }

    public Boolean getHttpOnly() {
        return this.httpOnly;
    }

    public void setSecure (Boolean secure) {
        this.secure = secure;
    }

    public Boolean getSecure() {
        return this.secure;
    }

    public void setSession (Boolean session) {
        this.session = session;
    }

    public Boolean getSession() {
        return this.session;
    }

    public void setSameSite (jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite) {
        this.sameSite = sameSite;
    }

    public jpuppeteer.cdp.client.constant.network.CookieSameSite getSameSite() {
        return this.sameSite;
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

    public Cookie(String name, String value, String domain, String path, java.math.BigDecimal expires, Integer size, Boolean httpOnly, Boolean secure, Boolean session, jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite, jpuppeteer.cdp.client.constant.network.CookiePriority priority, Boolean sameParty, jpuppeteer.cdp.client.constant.network.CookieSourceScheme sourceScheme, Integer sourcePort) {
        this.name = name;
        this.value = value;
        this.domain = domain;
        this.path = path;
        this.expires = expires;
        this.size = size;
        this.httpOnly = httpOnly;
        this.secure = secure;
        this.session = session;
        this.sameSite = sameSite;
        this.priority = priority;
        this.sameParty = sameParty;
        this.sourceScheme = sourceScheme;
        this.sourcePort = sourcePort;
    }

    public Cookie(String name, String value, String domain, String path, java.math.BigDecimal expires, Integer size, Boolean httpOnly, Boolean secure, Boolean session, jpuppeteer.cdp.client.constant.network.CookiePriority priority, Boolean sameParty, jpuppeteer.cdp.client.constant.network.CookieSourceScheme sourceScheme, Integer sourcePort) {
        this.name = name;
        this.value = value;
        this.domain = domain;
        this.path = path;
        this.expires = expires;
        this.size = size;
        this.httpOnly = httpOnly;
        this.secure = secure;
        this.session = session;
        this.sameSite = null;
        this.priority = priority;
        this.sameParty = sameParty;
        this.sourceScheme = sourceScheme;
        this.sourcePort = sourcePort;
    }

    public Cookie() {
    }

}