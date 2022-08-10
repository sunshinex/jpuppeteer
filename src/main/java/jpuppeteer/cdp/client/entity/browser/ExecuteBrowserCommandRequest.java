package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class ExecuteBrowserCommandRequest {

    /**
    */
    private jpuppeteer.cdp.client.constant.browser.BrowserCommandId commandId;

    public void setCommandId (jpuppeteer.cdp.client.constant.browser.BrowserCommandId commandId) {
        this.commandId = commandId;
    }

    public jpuppeteer.cdp.client.constant.browser.BrowserCommandId getCommandId() {
        return this.commandId;
    }

    public ExecuteBrowserCommandRequest(jpuppeteer.cdp.client.constant.browser.BrowserCommandId commandId) {
        this.commandId = commandId;
    }

    public ExecuteBrowserCommandRequest() {
    }

}