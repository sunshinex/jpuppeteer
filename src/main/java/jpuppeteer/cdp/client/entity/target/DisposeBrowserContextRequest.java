package jpuppeteer.cdp.client.entity.target;

/**
*/
public class DisposeBrowserContextRequest {

    /**
    */
    public final String browserContextId;

    public DisposeBrowserContextRequest(String browserContextId) {
        this.browserContextId = browserContextId;
    }

}