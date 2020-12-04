package jpuppeteer.cdp.client.domain;

/**
*/
public class Browser {

    private jpuppeteer.cdp.CDPConnection connection;

    public Browser(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Set permission settings for given origin.
    * experimental
    */
    public io.netty.util.concurrent.Future setPermission(jpuppeteer.cdp.client.entity.browser.SetPermissionRequest request) {
        return connection.send("Browser.setPermission", request);
    }


    /**
    * Grant specific permissions to the given origin and reject all others.
    * experimental
    */
    public io.netty.util.concurrent.Future grantPermissions(jpuppeteer.cdp.client.entity.browser.GrantPermissionsRequest request) {
        return connection.send("Browser.grantPermissions", request);
    }


    /**
    * Reset all permission management for all origins.
    * experimental
    */
    public io.netty.util.concurrent.Future resetPermissions(jpuppeteer.cdp.client.entity.browser.ResetPermissionsRequest request) {
        return connection.send("Browser.resetPermissions", request);
    }


    /**
    * Close browser gracefully.
    */
    public io.netty.util.concurrent.Future close() {
        return connection.send("Browser.close", null);
    }


    /**
    * Crashes browser on the main thread.
    * experimental
    */
    public io.netty.util.concurrent.Future crash() {
        return connection.send("Browser.crash", null);
    }


    /**
    * Crashes GPU process.
    * experimental
    */
    public io.netty.util.concurrent.Future crashGpuProcess() {
        return connection.send("Browser.crashGpuProcess", null);
    }


    /**
    * Returns version information.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.browser.GetVersionResponse> getVersion() {
        return connection.send("Browser.getVersion", null, jpuppeteer.cdp.client.entity.browser.GetVersionResponse.class);
    }


    /**
    * Returns the command line switches for the browser process if, and only if --enable-automation is on the commandline.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.browser.GetBrowserCommandLineResponse> getBrowserCommandLine() {
        return connection.send("Browser.getBrowserCommandLine", null, jpuppeteer.cdp.client.entity.browser.GetBrowserCommandLineResponse.class);
    }


    /**
    * Get Chrome histograms.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.browser.GetHistogramsResponse> getHistograms(jpuppeteer.cdp.client.entity.browser.GetHistogramsRequest request) {
        return connection.send("Browser.getHistograms", request, jpuppeteer.cdp.client.entity.browser.GetHistogramsResponse.class);
    }


    /**
    * Get a Chrome histogram by name.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.browser.GetHistogramResponse> getHistogram(jpuppeteer.cdp.client.entity.browser.GetHistogramRequest request) {
        return connection.send("Browser.getHistogram", request, jpuppeteer.cdp.client.entity.browser.GetHistogramResponse.class);
    }


    /**
    * Get position and size of the browser window.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.browser.GetWindowBoundsResponse> getWindowBounds(jpuppeteer.cdp.client.entity.browser.GetWindowBoundsRequest request) {
        return connection.send("Browser.getWindowBounds", request, jpuppeteer.cdp.client.entity.browser.GetWindowBoundsResponse.class);
    }


    /**
    * Get the browser window that contains the devtools target.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.browser.GetWindowForTargetResponse> getWindowForTarget(jpuppeteer.cdp.client.entity.browser.GetWindowForTargetRequest request) {
        return connection.send("Browser.getWindowForTarget", request, jpuppeteer.cdp.client.entity.browser.GetWindowForTargetResponse.class);
    }


    /**
    * Set position and/or size of the browser window.
    * experimental
    */
    public io.netty.util.concurrent.Future setWindowBounds(jpuppeteer.cdp.client.entity.browser.SetWindowBoundsRequest request) {
        return connection.send("Browser.setWindowBounds", request);
    }


    /**
    * Set dock tile details, platform-specific.
    * experimental
    */
    public io.netty.util.concurrent.Future setDockTile(jpuppeteer.cdp.client.entity.browser.SetDockTileRequest request) {
        return connection.send("Browser.setDockTile", request);
    }

}