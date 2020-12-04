package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetCookieRequest {

    /**
    * Cookie name.
    */
    public final String name;

    /**
    * Cookie value.
    */
    public final String value;

    /**
    * The request-URI to associate with the setting of the cookie. This value can affect the default domain and path values of the created cookie.
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
    public final String sameSite;

    /**
    * Cookie expiration date, session cookie if not set
    */
    public final java.math.BigDecimal expires;

    /**
    * Cookie Priority type.
    */
    public final String priority;

    public SetCookieRequest(String name, String value, String url, String domain, String path, Boolean secure, Boolean httpOnly, String sameSite, java.math.BigDecimal expires, String priority) {
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
    }

    public SetCookieRequest(String name, String value) {
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
    }

}