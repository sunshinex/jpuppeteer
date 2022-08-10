package jpuppeteer.cdp.client.entity.page;

/**
*/
public class DeleteCookieRequest {

    /**
    * Name of the cookie to remove.
    */
    private String cookieName;

    /**
    * URL to match cooke domain and path.
    */
    private String url;

    public void setCookieName (String cookieName) {
        this.cookieName = cookieName;
    }

    public String getCookieName() {
        return this.cookieName;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public DeleteCookieRequest(String cookieName, String url) {
        this.cookieName = cookieName;
        this.url = url;
    }

    public DeleteCookieRequest() {
    }

}