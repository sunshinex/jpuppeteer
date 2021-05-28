package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CreateBrowserContextResponse {

    /**
    * The id of the context created.
    */
    public final String browserContextId;

    public CreateBrowserContextResponse(String browserContextId) {
        this.browserContextId = browserContextId;
    }

}