package jpuppeteer.cdp.cdp.domain;

/**
*/
public class Browser {

    private jpuppeteer.cdp.CDPConnection connection;

    public Browser(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Grant specific permissions to the given origin and reject all others.
    */
    public void grantPermissions(jpuppeteer.cdp.cdp.entity.browser.GrantPermissionsRequest request, int timeout) throws Exception {
        connection.send("Browser.grantPermissions", request, timeout);
    }


    /**
    * Reset all permission management for all origins.
    */
    public void resetPermissions(jpuppeteer.cdp.cdp.entity.browser.ResetPermissionsRequest request, int timeout) throws Exception {
        connection.send("Browser.resetPermissions", request, timeout);
    }


    /**
    * Close browser gracefully.
    */
    public void close(int timeout) throws Exception {
        connection.send("Browser.close", null, timeout);
    }


    /**
    * Crashes browser on the main thread.
    */
    public void crash(int timeout) throws Exception {
        connection.send("Browser.crash", null, timeout);
    }


    /**
    * Crashes GPU process.
    */
    public void crashGpuProcess(int timeout) throws Exception {
        connection.send("Browser.crashGpuProcess", null, timeout);
    }


    /**
    * Returns version information.
    */
    public jpuppeteer.cdp.cdp.entity.browser.GetVersionResponse getVersion(int timeout) throws Exception {
        return connection.send("Browser.getVersion", null, jpuppeteer.cdp.cdp.entity.browser.GetVersionResponse.class, timeout);
    }


    /**
    * Returns the command line switches for the browser process if, and only if --enable-automation is on the commandline.
    */
    public jpuppeteer.cdp.cdp.entity.browser.GetBrowserCommandLineResponse getBrowserCommandLine(int timeout) throws Exception {
        return connection.send("Browser.getBrowserCommandLine", null, jpuppeteer.cdp.cdp.entity.browser.GetBrowserCommandLineResponse.class, timeout);
    }


    /**
    * Get Chrome histograms.
    */
    public jpuppeteer.cdp.cdp.entity.browser.GetHistogramsResponse getHistograms(jpuppeteer.cdp.cdp.entity.browser.GetHistogramsRequest request, int timeout) throws Exception {
        return connection.send("Browser.getHistograms", request, jpuppeteer.cdp.cdp.entity.browser.GetHistogramsResponse.class, timeout);
    }


    /**
    * Get a Chrome histogram by name.
    */
    public jpuppeteer.cdp.cdp.entity.browser.GetHistogramResponse getHistogram(jpuppeteer.cdp.cdp.entity.browser.GetHistogramRequest request, int timeout) throws Exception {
        return connection.send("Browser.getHistogram", request, jpuppeteer.cdp.cdp.entity.browser.GetHistogramResponse.class, timeout);
    }


    /**
    * Get position and size of the browser window.
    */
    public jpuppeteer.cdp.cdp.entity.browser.GetWindowBoundsResponse getWindowBounds(jpuppeteer.cdp.cdp.entity.browser.GetWindowBoundsRequest request, int timeout) throws Exception {
        return connection.send("Browser.getWindowBounds", request, jpuppeteer.cdp.cdp.entity.browser.GetWindowBoundsResponse.class, timeout);
    }


    /**
    * Get the browser window that contains the devtools target.
    */
    public jpuppeteer.cdp.cdp.entity.browser.GetWindowForTargetResponse getWindowForTarget(jpuppeteer.cdp.cdp.entity.browser.GetWindowForTargetRequest request, int timeout) throws Exception {
        return connection.send("Browser.getWindowForTarget", request, jpuppeteer.cdp.cdp.entity.browser.GetWindowForTargetResponse.class, timeout);
    }


    /**
    * Set position and/or size of the browser window.
    */
    public void setWindowBounds(jpuppeteer.cdp.cdp.entity.browser.SetWindowBoundsRequest request, int timeout) throws Exception {
        connection.send("Browser.setWindowBounds", request, timeout);
    }


    /**
    * Set dock tile details, platform-specific.
    */
    public void setDockTile(jpuppeteer.cdp.cdp.entity.browser.SetDockTileRequest request, int timeout) throws Exception {
        connection.send("Browser.setDockTile", request, timeout);
    }

}