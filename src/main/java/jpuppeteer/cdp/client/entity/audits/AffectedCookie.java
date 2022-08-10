package jpuppeteer.cdp.client.entity.audits;

/**
* Information about a cookie that is affected by an inspector issue.
* experimental
*/
public class AffectedCookie {

    /**
    * The following three properties uniquely identify a cookie
    */
    private String name;

    /**
    */
    private String path;

    /**
    */
    private String domain;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPath (String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void setDomain (String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return this.domain;
    }

    public AffectedCookie(String name, String path, String domain) {
        this.name = name;
        this.path = path;
        this.domain = domain;
    }

    public AffectedCookie() {
    }

}