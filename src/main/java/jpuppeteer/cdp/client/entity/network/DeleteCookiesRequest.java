package jpuppeteer.cdp.client.entity.network;

/**
*/
public class DeleteCookiesRequest {

    /**
    * Name of the cookies to remove.
    */
    private String name;

    /**
    * If specified, deletes all the cookies with the given name where domain and path match provided URL.
    */
    private String url;

    /**
    * If specified, deletes only cookies with the exact domain.
    */
    private String domain;

    /**
    * If specified, deletes only cookies with the exact path.
    */
    private String path;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    public DeleteCookiesRequest(String name, String url, String domain, String path) {
        this.name = name;
        this.url = url;
        this.domain = domain;
        this.path = path;
    }

    public DeleteCookiesRequest(String name) {
        this.name = name;
        this.url = null;
        this.domain = null;
        this.path = null;
    }

    public DeleteCookiesRequest() {
    }

}