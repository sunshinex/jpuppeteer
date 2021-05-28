package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class ExecuteBrowserCommandRequest {

    /**
    */
    public final jpuppeteer.cdp.client.constant.browser.BrowserCommandId commandId;

    public ExecuteBrowserCommandRequest(jpuppeteer.cdp.client.constant.browser.BrowserCommandId commandId) {
        this.commandId = commandId;
    }

}