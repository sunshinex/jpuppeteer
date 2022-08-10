package jpuppeteer.cdp.client.entity.target;

/**
*/
public class CreateBrowserContextRequest {

    /**
    * If specified, disposes this context when debugging session disconnects.
    */
    private Boolean disposeOnDetach;

    /**
    * Proxy server, similar to the one passed to --proxy-server
    */
    private String proxyServer;

    /**
    * Proxy bypass list, similar to the one passed to --proxy-bypass-list
    */
    private String proxyBypassList;

    public void setDisposeOnDetach (Boolean disposeOnDetach) {
        this.disposeOnDetach = disposeOnDetach;
    }

    public Boolean getDisposeOnDetach() {
        return this.disposeOnDetach;
    }

    public void setProxyServer (String proxyServer) {
        this.proxyServer = proxyServer;
    }

    public String getProxyServer() {
        return this.proxyServer;
    }

    public void setProxyBypassList (String proxyBypassList) {
        this.proxyBypassList = proxyBypassList;
    }

    public String getProxyBypassList() {
        return this.proxyBypassList;
    }

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