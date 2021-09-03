package jpuppeteer.cdp.client.entity.network;

/**
* Cookie object
*/
public class Cookie {

    /**
    * Cookie name.
    */
    public final String name;

    /**
    * Cookie value.
    */
    public final String value;

    /**
    * Cookie domain.
    */
    public final String domain;

    /**
    * Cookie path.
    */
    public final String path;

    /**
    * Cookie expiration date as the number of seconds since the UNIX epoch.
    */
    public final java.math.BigDecimal expires;

    /**
    * Cookie size.
    */
    public final Integer size;

    /**
    * True if cookie is http-only.
    */
    public final Boolean httpOnly;

    /**
    * True if cookie is secure.
    */
    public final Boolean secure;

    /**
    * True in case of session cookie.
    */
    public final Boolean session;

    /**
    * Cookie SameSite type.
    */
    public final jpuppeteer.cdp.client.constant.network.CookieSameSite sameSite;

    /**
    * Cookie Priority
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

}