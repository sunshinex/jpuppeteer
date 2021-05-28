package jpuppeteer.cdp.client.entity.page;

/**
*/
public class DeleteCookieRequest {

    /**
    * Name of the cookie to remove.
    */
    public final String cookieName;

    /**
    * URL to match cooke domain and path.
    */
    public final String url;

    public DeleteCookieRequest(String cookieName, String url) {
        this.cookieName = cookieName;
        this.url = url;
    }

}