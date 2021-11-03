package jpuppeteer.cdp.client.domain;

/**
*/
public class Page {

    private jpuppeteer.cdp.CDPConnection connection;

    public Page(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnLoadResponse> addScriptToEvaluateOnLoad(jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnLoadRequest request) {
        return connection.send("Page.addScriptToEvaluateOnLoad", request, jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnLoadResponse.class);
    }


    /**
    * Evaluates given script in every frame upon creation (before loading frame's scripts).
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnNewDocumentResponse> addScriptToEvaluateOnNewDocument(jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnNewDocumentRequest request) {
        return connection.send("Page.addScriptToEvaluateOnNewDocument", request, jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnNewDocumentResponse.class);
    }


    /**
    * Brings page to front (activates tab).
    */
    public io.netty.util.concurrent.Future bringToFront() {
        return connection.send("Page.bringToFront", null);
    }


    /**
    * Capture page screenshot.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.CaptureScreenshotResponse> captureScreenshot(jpuppeteer.cdp.client.entity.page.CaptureScreenshotRequest request) {
        return connection.send("Page.captureScreenshot", request, jpuppeteer.cdp.client.entity.page.CaptureScreenshotResponse.class);
    }


    /**
    * Returns a snapshot of the page as a string. For MHTML format, the serialization includes iframes, shadow DOM, external resources, and element-inline styles.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.CaptureSnapshotResponse> captureSnapshot(jpuppeteer.cdp.client.entity.page.CaptureSnapshotRequest request) {
        return connection.send("Page.captureSnapshot", request, jpuppeteer.cdp.client.entity.page.CaptureSnapshotResponse.class);
    }


    /**
    * Clears the overridden device metrics.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future clearDeviceMetricsOverride() {
        return connection.send("Page.clearDeviceMetricsOverride", null);
    }


    /**
    * Clears the overridden Device Orientation.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future clearDeviceOrientationOverride() {
        return connection.send("Page.clearDeviceOrientationOverride", null);
    }


    /**
    * Clears the overridden Geolocation Position and Error.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future clearGeolocationOverride() {
        return connection.send("Page.clearGeolocationOverride", null);
    }


    /**
    * Creates an isolated world for the given frame.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldResponse> createIsolatedWorld(jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldRequest request) {
        return connection.send("Page.createIsolatedWorld", request, jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldResponse.class);
    }


    /**
    * Deletes browser cookie with given name, domain and path.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future deleteCookie(jpuppeteer.cdp.client.entity.page.DeleteCookieRequest request) {
        return connection.send("Page.deleteCookie", request);
    }


    /**
    * Disables page domain notifications.
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("Page.disable", null);
    }


    /**
    * Enables page domain notifications.
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("Page.enable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetAppManifestResponse> getAppManifest() {
        return connection.send("Page.getAppManifest", null, jpuppeteer.cdp.client.entity.page.GetAppManifestResponse.class);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetInstallabilityErrorsResponse> getInstallabilityErrors() {
        return connection.send("Page.getInstallabilityErrors", null, jpuppeteer.cdp.client.entity.page.GetInstallabilityErrorsResponse.class);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetManifestIconsResponse> getManifestIcons() {
        return connection.send("Page.getManifestIcons", null, jpuppeteer.cdp.client.entity.page.GetManifestIconsResponse.class);
    }


    /**
    * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the `cookies` field.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetCookiesResponse> getCookies() {
        return connection.send("Page.getCookies", null, jpuppeteer.cdp.client.entity.page.GetCookiesResponse.class);
    }


    /**
    * Returns present frame tree structure.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetFrameTreeResponse> getFrameTree() {
        return connection.send("Page.getFrameTree", null, jpuppeteer.cdp.client.entity.page.GetFrameTreeResponse.class);
    }


    /**
    * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetLayoutMetricsResponse> getLayoutMetrics() {
        return connection.send("Page.getLayoutMetrics", null, jpuppeteer.cdp.client.entity.page.GetLayoutMetricsResponse.class);
    }


    /**
    * Returns navigation history for the current page.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetNavigationHistoryResponse> getNavigationHistory() {
        return connection.send("Page.getNavigationHistory", null, jpuppeteer.cdp.client.entity.page.GetNavigationHistoryResponse.class);
    }


    /**
    * Resets navigation history for the current page.
    */
    public io.netty.util.concurrent.Future resetNavigationHistory() {
        return connection.send("Page.resetNavigationHistory", null);
    }


    /**
    * Returns content of the given resource.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetResourceContentResponse> getResourceContent(jpuppeteer.cdp.client.entity.page.GetResourceContentRequest request) {
        return connection.send("Page.getResourceContent", request, jpuppeteer.cdp.client.entity.page.GetResourceContentResponse.class);
    }


    /**
    * Returns present frame / resource tree structure.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetResourceTreeResponse> getResourceTree() {
        return connection.send("Page.getResourceTree", null, jpuppeteer.cdp.client.entity.page.GetResourceTreeResponse.class);
    }


    /**
    * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
    */
    public io.netty.util.concurrent.Future handleJavaScriptDialog(jpuppeteer.cdp.client.entity.page.HandleJavaScriptDialogRequest request) {
        return connection.send("Page.handleJavaScriptDialog", request);
    }


    /**
    * Navigates current page to the given URL.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.NavigateResponse> navigate(jpuppeteer.cdp.client.entity.page.NavigateRequest request) {
        return connection.send("Page.navigate", request, jpuppeteer.cdp.client.entity.page.NavigateResponse.class);
    }


    /**
    * Navigates current page to the given history entry.
    */
    public io.netty.util.concurrent.Future navigateToHistoryEntry(jpuppeteer.cdp.client.entity.page.NavigateToHistoryEntryRequest request) {
        return connection.send("Page.navigateToHistoryEntry", request);
    }


    /**
    * Print page as PDF.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.PrintToPDFResponse> printToPDF(jpuppeteer.cdp.client.entity.page.PrintToPDFRequest request) {
        return connection.send("Page.printToPDF", request, jpuppeteer.cdp.client.entity.page.PrintToPDFResponse.class);
    }


    /**
    * Reloads given page optionally ignoring the cache.
    */
    public io.netty.util.concurrent.Future reload(jpuppeteer.cdp.client.entity.page.ReloadRequest request) {
        return connection.send("Page.reload", request);
    }


    /**
    * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future removeScriptToEvaluateOnLoad(jpuppeteer.cdp.client.entity.page.RemoveScriptToEvaluateOnLoadRequest request) {
        return connection.send("Page.removeScriptToEvaluateOnLoad", request);
    }


    /**
    * Removes given script from the list.
    */
    public io.netty.util.concurrent.Future removeScriptToEvaluateOnNewDocument(jpuppeteer.cdp.client.entity.page.RemoveScriptToEvaluateOnNewDocumentRequest request) {
        return connection.send("Page.removeScriptToEvaluateOnNewDocument", request);
    }


    /**
    * Acknowledges that a screencast frame has been received by the frontend.
    * experimental
    */
    public io.netty.util.concurrent.Future screencastFrameAck(jpuppeteer.cdp.client.entity.page.ScreencastFrameAckRequest request) {
        return connection.send("Page.screencastFrameAck", request);
    }


    /**
    * Searches for given string in resource content.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.SearchInResourceResponse> searchInResource(jpuppeteer.cdp.client.entity.page.SearchInResourceRequest request) {
        return connection.send("Page.searchInResource", request, jpuppeteer.cdp.client.entity.page.SearchInResourceResponse.class);
    }


    /**
    * Enable Chrome's experimental ad filter on all sites.
    * experimental
    */
    public io.netty.util.concurrent.Future setAdBlockingEnabled(jpuppeteer.cdp.client.entity.page.SetAdBlockingEnabledRequest request) {
        return connection.send("Page.setAdBlockingEnabled", request);
    }


    /**
    * Enable page Content Security Policy by-passing.
    * experimental
    */
    public io.netty.util.concurrent.Future setBypassCSP(jpuppeteer.cdp.client.entity.page.SetBypassCSPRequest request) {
        return connection.send("Page.setBypassCSP", request);
    }


    /**
    * Get Permissions Policy state on given frame.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetPermissionsPolicyStateResponse> getPermissionsPolicyState(jpuppeteer.cdp.client.entity.page.GetPermissionsPolicyStateRequest request) {
        return connection.send("Page.getPermissionsPolicyState", request, jpuppeteer.cdp.client.entity.page.GetPermissionsPolicyStateResponse.class);
    }


    /**
    * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setDeviceMetricsOverride(jpuppeteer.cdp.client.entity.page.SetDeviceMetricsOverrideRequest request) {
        return connection.send("Page.setDeviceMetricsOverride", request);
    }


    /**
    * Overrides the Device Orientation.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setDeviceOrientationOverride(jpuppeteer.cdp.client.entity.page.SetDeviceOrientationOverrideRequest request) {
        return connection.send("Page.setDeviceOrientationOverride", request);
    }


    /**
    * Set generic font families.
    * experimental
    */
    public io.netty.util.concurrent.Future setFontFamilies(jpuppeteer.cdp.client.entity.page.SetFontFamiliesRequest request) {
        return connection.send("Page.setFontFamilies", request);
    }


    /**
    * Set default font sizes.
    * experimental
    */
    public io.netty.util.concurrent.Future setFontSizes(jpuppeteer.cdp.client.entity.page.SetFontSizesRequest request) {
        return connection.send("Page.setFontSizes", request);
    }


    /**
    * Sets given markup as the document's HTML.
    */
    public io.netty.util.concurrent.Future setDocumentContent(jpuppeteer.cdp.client.entity.page.SetDocumentContentRequest request) {
        return connection.send("Page.setDocumentContent", request);
    }


    /**
    * Set the behavior when downloading a file.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setDownloadBehavior(jpuppeteer.cdp.client.entity.page.SetDownloadBehaviorRequest request) {
        return connection.send("Page.setDownloadBehavior", request);
    }


    /**
    * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setGeolocationOverride(jpuppeteer.cdp.client.entity.page.SetGeolocationOverrideRequest request) {
        return connection.send("Page.setGeolocationOverride", request);
    }


    /**
    * Controls whether page will emit lifecycle events.
    * experimental
    */
    public io.netty.util.concurrent.Future setLifecycleEventsEnabled(jpuppeteer.cdp.client.entity.page.SetLifecycleEventsEnabledRequest request) {
        return connection.send("Page.setLifecycleEventsEnabled", request);
    }


    /**
    * Toggles mouse event-based touch event emulation.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setTouchEmulationEnabled(jpuppeteer.cdp.client.entity.page.SetTouchEmulationEnabledRequest request) {
        return connection.send("Page.setTouchEmulationEnabled", request);
    }


    /**
    * Starts sending each frame using the `screencastFrame` event.
    * experimental
    */
    public io.netty.util.concurrent.Future startScreencast(jpuppeteer.cdp.client.entity.page.StartScreencastRequest request) {
        return connection.send("Page.startScreencast", request);
    }


    /**
    * Force the page stop all navigations and pending resource fetches.
    */
    public io.netty.util.concurrent.Future stopLoading() {
        return connection.send("Page.stopLoading", null);
    }


    /**
    * Crashes renderer on the IO thread, generates minidumps.
    * experimental
    */
    public io.netty.util.concurrent.Future crash() {
        return connection.send("Page.crash", null);
    }


    /**
    * Tries to close page, running its beforeunload hooks, if any.
    * experimental
    */
    public io.netty.util.concurrent.Future close() {
        return connection.send("Page.close", null);
    }


    /**
    * Tries to update the web lifecycle state of the page. It will transition the page to the given state according to: https://github.com/WICG/web-lifecycle/
    * experimental
    */
    public io.netty.util.concurrent.Future setWebLifecycleState(jpuppeteer.cdp.client.entity.page.SetWebLifecycleStateRequest request) {
        return connection.send("Page.setWebLifecycleState", request);
    }


    /**
    * Stops sending each frame in the `screencastFrame`.
    * experimental
    */
    public io.netty.util.concurrent.Future stopScreencast() {
        return connection.send("Page.stopScreencast", null);
    }


    /**
    * Forces compilation cache to be generated for every subresource script. See also: `Page.produceCompilationCache`.
    * experimental
    */
    public io.netty.util.concurrent.Future setProduceCompilationCache(jpuppeteer.cdp.client.entity.page.SetProduceCompilationCacheRequest request) {
        return connection.send("Page.setProduceCompilationCache", request);
    }


    /**
    * Requests backend to produce compilation cache for the specified scripts. Unlike setProduceCompilationCache, this allows client to only produce cache for specific scripts. `scripts` are appeneded to the list of scripts for which the cache for would produced. Disabling compilation cache with `setProduceCompilationCache` would reset all pending cache requests. The list may also be reset during page navigation. When script with a matching URL is encountered, the cache is optionally produced upon backend discretion, based on internal heuristics. See also: `Page.compilationCacheProduced`.
    * experimental
    */
    public io.netty.util.concurrent.Future produceCompilationCache(jpuppeteer.cdp.client.entity.page.ProduceCompilationCacheRequest request) {
        return connection.send("Page.produceCompilationCache", request);
    }


    /**
    * Seeds compilation cache for given url. Compilation cache does not survive cross-process navigation.
    * experimental
    */
    public io.netty.util.concurrent.Future addCompilationCache(jpuppeteer.cdp.client.entity.page.AddCompilationCacheRequest request) {
        return connection.send("Page.addCompilationCache", request);
    }


    /**
    * Clears seeded compilation cache.
    * experimental
    */
    public io.netty.util.concurrent.Future clearCompilationCache() {
        return connection.send("Page.clearCompilationCache", null);
    }


    /**
    * Generates a report for testing.
    * experimental
    */
    public io.netty.util.concurrent.Future generateTestReport(jpuppeteer.cdp.client.entity.page.GenerateTestReportRequest request) {
        return connection.send("Page.generateTestReport", request);
    }


    /**
    * Pauses page execution. Can be resumed using generic Runtime.runIfWaitingForDebugger.
    * experimental
    */
    public io.netty.util.concurrent.Future waitForDebugger() {
        return connection.send("Page.waitForDebugger", null);
    }


    /**
    * Intercept file chooser requests and transfer control to protocol clients. When file chooser interception is enabled, native file chooser dialog is not shown. Instead, a protocol event `Page.fileChooserOpened` is emitted.
    * experimental
    */
    public io.netty.util.concurrent.Future setInterceptFileChooserDialog(jpuppeteer.cdp.client.entity.page.SetInterceptFileChooserDialogRequest request) {
        return connection.send("Page.setInterceptFileChooserDialog", request);
    }

}