package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CreateBrowserContextRequest {

    /**
    * If specified, disposes this context when debugging session disconnects.
    */
    public final Boolean disposeOnDetach;

    /**
    * Proxy server, similar to the one passed to --proxy-server
    */
    public final String proxyServer;

    /**
    * Proxy bypass list, similar to the one passed to --proxy-bypass-list
    */
    public final String proxyBypassList;

    public CreateBrowserContextRequest(Boolean disposeOnDetach, String proxyServer, String proxyBypassList) {
        this.disposeOnDetach = disposeOnDetach;
        this.proxyServer = proxyServer;
        this.proxyBypassList = proxyBypassList;
    }

    public CreateBrowserContextRequest() {
        this.disposeOnDetach = null;
        this.proxyServer = null;
        this.proxyBypassList = null;
    }

}