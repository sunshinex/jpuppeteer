package jpuppeteer.cdp.client.entity.network;

/**
*/
public class DeleteCookiesRequest {

    /**
    * Name of the cookies to remove.
    */
    public final String name;

    /**
    * If specified, deletes all the cookies with the given name where domain and path match provided URL.
    */
    public final String url;

    /**
    * If specified, deletes only cookies with the exact domain.
    */
    public final String domain;

    /**
    * If specified, deletes only cookies with the exact path.
    */
    public final String path;

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

}