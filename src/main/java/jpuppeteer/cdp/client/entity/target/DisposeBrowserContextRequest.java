package jpuppeteer.cdp.client.entity.target;

/**
*/
public class DisposeBrowserContextRequest {

    /**
    */
    private String browserContextId;

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

    public DisposeBrowserContextRequest(String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public DisposeBrowserContextRequest() {
    }

}