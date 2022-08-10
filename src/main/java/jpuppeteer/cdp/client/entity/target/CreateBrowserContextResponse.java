package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CreateBrowserContextResponse {

    /**
    * The id of the context created.
    */
    private String browserContextId;

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

    public CreateBrowserContextResponse(String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public CreateBrowserContextResponse() {
    }

}