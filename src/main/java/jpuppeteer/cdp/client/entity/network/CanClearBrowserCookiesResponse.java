package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CanClearBrowserCookiesResponse {

    /**
    * True if browser cookies can be cleared.
    */
    private Boolean result;

    public void setResult (Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return this.result;
    }

    public CanClearBrowserCookiesResponse(Boolean result) {
        this.result = result;
    }

    public CanClearBrowserCookiesResponse() {
    }

}