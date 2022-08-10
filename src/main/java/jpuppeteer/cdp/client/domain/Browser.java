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
    public jpuppeteer.util.XFuture<?> setPermission(jpuppeteer.cdp.client.entity.browser.SetPermissionRequest request) {
        return connection.send("Browser.setPermission", request);
    }


    /**
    * Grant specific permissions to the given origin and reject all others.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> grantPermissions(jpuppeteer.cdp.client.entity.browser.GrantPermissionsRequest request) {
        return connection.send("Browser.grantPermissions", request);
    }


    /**
    * Reset all permission management for all origins.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> resetPermissions(jpuppeteer.cdp.client.entity.browser.ResetPermissionsRequest request) {
        return connection.send("Browser.resetPermissions", request);
    }


    /**
    * Set the behavior when downloading a file.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> setDownloadBehavior(jpuppeteer.cdp.client.entity.browser.SetDownloadBehaviorRequest request) {
        return connection.send("Browser.setDownloadBehavior", request);
    }


    /**
    * Cancel a download if in progress
    * experimental
    */
    public jpuppeteer.util.XFuture<?> cancelDownload(jpuppeteer.cdp.client.entity.browser.CancelDownloadRequest request) {
        return connection.send("Browser.cancelDownload", request);
    }


    /**
    * Close browser gracefully.
    */
    public jpuppeteer.util.XFuture<?> close() {
        return connection.send("Browser.close", null);
    }


    /**
    * Crashes browser on the main thread.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> crash() {
        return connection.send("Browser.crash", null);
    }


    /**
    * Crashes GPU process.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> crashGpuProcess() {
        return connection.send("Browser.crashGpuProcess", null);
    }


    /**
    * Returns version information.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.browser.GetVersionResponse> getVersion() {
        return connection.send("Browser.getVersion", null, jpuppeteer.cdp.client.entity.browser.GetVersionResponse.class);
    }


    /**
    * Returns the command line switches for the browser process if, and only if --enable-automation is on the commandline.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.browser.GetBrowserCommandLineResponse> getBrowserCommandLine() {
        return connection.send("Browser.getBrowserCommandLine", null, jpuppeteer.cdp.client.entity.browser.GetBrowserCommandLineResponse.class);
    }


    /**
    * Get Chrome histograms.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.browser.GetHistogramsResponse> getHistograms(jpuppeteer.cdp.client.entity.browser.GetHistogramsRequest request) {
        return connection.send("Browser.getHistograms", request, jpuppeteer.cdp.client.entity.browser.GetHistogramsResponse.class);
    }


    /**
    * Get a Chrome histogram by name.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.browser.GetHistogramResponse> getHistogram(jpuppeteer.cdp.client.entity.browser.GetHistogramRequest request) {
        return connection.send("Browser.getHistogram", request, jpuppeteer.cdp.client.entity.browser.GetHistogramResponse.class);
    }


    /**
    * Get position and size of the browser window.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.browser.GetWindowBoundsResponse> getWindowBounds(jpuppeteer.cdp.client.entity.browser.GetWindowBoundsRequest request) {
        return connection.send("Browser.getWindowBounds", request, jpuppeteer.cdp.client.entity.browser.GetWindowBoundsResponse.class);
    }


    /**
    * Get the browser window that contains the devtools target.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.browser.GetWindowForTargetResponse> getWindowForTarget(jpuppeteer.cdp.client.entity.browser.GetWindowForTargetRequest request) {
        return connection.send("Browser.getWindowForTarget", request, jpuppeteer.cdp.client.entity.browser.GetWindowForTargetResponse.class);
    }


    /**
    * Set position and/or size of the browser window.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> setWindowBounds(jpuppeteer.cdp.client.entity.browser.SetWindowBoundsRequest request) {
        return connection.send("Browser.setWindowBounds", request);
    }


    /**
    * Set dock tile details, platform-specific.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> setDockTile(jpuppeteer.cdp.client.entity.browser.SetDockTileRequest request) {
        return connection.send("Browser.setDockTile", request);
    }


    /**
    * Invoke custom browser commands used by telemetry.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> executeBrowserCommand(jpuppeteer.cdp.client.entity.browser.ExecuteBrowserCommandRequest request) {
        return connection.send("Browser.executeBrowserCommand", request);
    }

}