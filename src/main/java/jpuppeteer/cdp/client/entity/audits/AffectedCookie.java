package jpuppeteer.cdp.client.entity.audits;

/**
* Information about a cookie that is affected by an inspector issue.
* experimental
*/
public class AffectedCookie {

    /**
    * The following three properties uniquely identify a cookie
    */
    public final String name;

    /**
    */
    public final String path;

    /**
    */
    public final String domain;

    public AffectedCookie(String name, String path, String domain) {
        this.name = name;
        this.path = path;
        this.domain = domain;
    }

}