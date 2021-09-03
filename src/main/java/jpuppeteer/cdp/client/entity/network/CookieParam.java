package jpuppeteer.cdp.client.entity.network;

/**
* Cookie parameter object
*/
public class CookieParam {

    /**
    * Cookie name.
    */
    public final String name;

    /**
    * Cookie value.
    */
    public final String value;

    /**
    * The request-URI to associate with the setting of the cookie. This value can affect the default domain, path, source port, and source scheme values of the created cookie.
    */
    public final String url;

    /**
    * Cookie domain.
    */
    public final String domain;

    /**
    * Cookie path.
    */
    public final String path;

    /**
    * True if cookie is secure.
    */
    public final Boolean secure;

    /**
    * True if cookie is http-only.
    */
    public final Boolean httpOnly;

    /**
    * Cookie SameSite type.
    */
    public final jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite;

    /**
    * Cookie expiration date, session cookie if not set
    */
    public final java.math.BigDecimal expires;

    /**
    * Cookie Priority.
    */
    public final jpuppeteer.cdp.client.constant.network.CookiePriority priority;

    /**
    * True if cookie is SameParty.
    */
    public final Boolean sameParty;

    /**
    * Cookie source scheme type.
    */
    public final jpuppeteer.cdp.client.constant.network.CookieSourceScheme sourceScheme;

    /**
    * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port. An unspecified port value allows protocol clients to emulate legacy cookie scope for the port. This is a temporary ability and it will be removed in the future.
    */
    public final Integer sourcePort;

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

}