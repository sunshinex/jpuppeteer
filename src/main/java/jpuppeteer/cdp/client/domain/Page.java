package jpuppeteer.cdp.client.domain;

/**
*/
public class Page {

    private jpuppeteer.cdp.CDPSession session;

    public Page(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnLoadResponse> addScriptToEvaluateOnLoad(jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnLoadRequest request) {
        return session.send("Page.addScriptToEvaluateOnLoad", request, jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnLoadResponse.class);
    }


    /**
    * Evaluates given script in every frame upon creation (before loading frame's scripts).
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnNewDocumentResponse> addScriptToEvaluateOnNewDocument(jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnNewDocumentRequest request) {
        return session.send("Page.addScriptToEvaluateOnNewDocument", request, jpuppeteer.cdp.client.entity.page.AddScriptToEvaluateOnNewDocumentResponse.class);
    }


    /**
    * Brings page to front (activates tab).
    */
    public io.netty.util.concurrent.Future bringToFront() {
        return session.send("Page.bringToFront", null);
    }


    /**
    * Capture page screenshot.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.CaptureScreenshotResponse> captureScreenshot(jpuppeteer.cdp.client.entity.page.CaptureScreenshotRequest request) {
        return session.send("Page.captureScreenshot", request, jpuppeteer.cdp.client.entity.page.CaptureScreenshotResponse.class);
    }


    /**
    * Returns a snapshot of the page as a string. For MHTML format, the serialization includes iframes, shadow DOM, external resources, and element-inline styles.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.CaptureSnapshotResponse> captureSnapshot(jpuppeteer.cdp.client.entity.page.CaptureSnapshotRequest request) {
        return session.send("Page.captureSnapshot", request, jpuppeteer.cdp.client.entity.page.CaptureSnapshotResponse.class);
    }


    /**
    * Clears the overriden device metrics.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future clearDeviceMetricsOverride() {
        return session.send("Page.clearDeviceMetricsOverride", null);
    }


    /**
    * Clears the overridden Device Orientation.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future clearDeviceOrientationOverride() {
        return session.send("Page.clearDeviceOrientationOverride", null);
    }


    /**
    * Clears the overriden Geolocation Position and Error.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future clearGeolocationOverride() {
        return session.send("Page.clearGeolocationOverride", null);
    }


    /**
    * Creates an isolated world for the given frame.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldResponse> createIsolatedWorld(jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldRequest request) {
        return session.send("Page.createIsolatedWorld", request, jpuppeteer.cdp.client.entity.page.CreateIsolatedWorldResponse.class);
    }


    /**
    * Deletes browser cookie with given name, domain and path.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future deleteCookie(jpuppeteer.cdp.client.entity.page.DeleteCookieRequest request) {
        return session.send("Page.deleteCookie", request);
    }


    /**
    * Disables page domain notifications.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Page.disable", null);
    }


    /**
    * Enables page domain notifications.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Page.enable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetAppManifestResponse> getAppManifest() {
        return session.send("Page.getAppManifest", null, jpuppeteer.cdp.client.entity.page.GetAppManifestResponse.class);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetInstallabilityErrorsResponse> getInstallabilityErrors() {
        return session.send("Page.getInstallabilityErrors", null, jpuppeteer.cdp.client.entity.page.GetInstallabilityErrorsResponse.class);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetManifestIconsResponse> getManifestIcons() {
        return session.send("Page.getManifestIcons", null, jpuppeteer.cdp.client.entity.page.GetManifestIconsResponse.class);
    }


    /**
    * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the `cookies` field.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetCookiesResponse> getCookies() {
        return session.send("Page.getCookies", null, jpuppeteer.cdp.client.entity.page.GetCookiesResponse.class);
    }


    /**
    * Returns present frame tree structure.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetFrameTreeResponse> getFrameTree() {
        return session.send("Page.getFrameTree", null, jpuppeteer.cdp.client.entity.page.GetFrameTreeResponse.class);
    }


    /**
    * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetLayoutMetricsResponse> getLayoutMetrics() {
        return session.send("Page.getLayoutMetrics", null, jpuppeteer.cdp.client.entity.page.GetLayoutMetricsResponse.class);
    }


    /**
    * Returns navigation history for the current page.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetNavigationHistoryResponse> getNavigationHistory() {
        return session.send("Page.getNavigationHistory", null, jpuppeteer.cdp.client.entity.page.GetNavigationHistoryResponse.class);
    }


    /**
    * Resets navigation history for the current page.
    */
    public io.netty.util.concurrent.Future resetNavigationHistory() {
        return session.send("Page.resetNavigationHistory", null);
    }


    /**
    * Returns content of the given resource.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetResourceContentResponse> getResourceContent(jpuppeteer.cdp.client.entity.page.GetResourceContentRequest request) {
        return session.send("Page.getResourceContent", request, jpuppeteer.cdp.client.entity.page.GetResourceContentResponse.class);
    }


    /**
    * Returns present frame / resource tree structure.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.GetResourceTreeResponse> getResourceTree() {
        return session.send("Page.getResourceTree", null, jpuppeteer.cdp.client.entity.page.GetResourceTreeResponse.class);
    }


    /**
    * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
    */
    public io.netty.util.concurrent.Future handleJavaScriptDialog(jpuppeteer.cdp.client.entity.page.HandleJavaScriptDialogRequest request) {
        return session.send("Page.handleJavaScriptDialog", request);
    }


    /**
    * Navigates current page to the given URL.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.NavigateResponse> navigate(jpuppeteer.cdp.client.entity.page.NavigateRequest request) {
        return session.send("Page.navigate", request, jpuppeteer.cdp.client.entity.page.NavigateResponse.class);
    }


    /**
    * Navigates current page to the given history entry.
    */
    public io.netty.util.concurrent.Future navigateToHistoryEntry(jpuppeteer.cdp.client.entity.page.NavigateToHistoryEntryRequest request) {
        return session.send("Page.navigateToHistoryEntry", request);
    }


    /**
    * Print page as PDF.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.PrintToPDFResponse> printToPDF(jpuppeteer.cdp.client.entity.page.PrintToPDFRequest request) {
        return session.send("Page.printToPDF", request, jpuppeteer.cdp.client.entity.page.PrintToPDFResponse.class);
    }


    /**
    * Reloads given page optionally ignoring the cache.
    */
    public io.netty.util.concurrent.Future reload(jpuppeteer.cdp.client.entity.page.ReloadRequest request) {
        return session.send("Page.reload", request);
    }


    /**
    * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future removeScriptToEvaluateOnLoad(jpuppeteer.cdp.client.entity.page.RemoveScriptToEvaluateOnLoadRequest request) {
        return session.send("Page.removeScriptToEvaluateOnLoad", request);
    }


    /**
    * Removes given script from the list.
    */
    public io.netty.util.concurrent.Future removeScriptToEvaluateOnNewDocument(jpuppeteer.cdp.client.entity.page.RemoveScriptToEvaluateOnNewDocumentRequest request) {
        return session.send("Page.removeScriptToEvaluateOnNewDocument", request);
    }


    /**
    * Acknowledges that a screencast frame has been received by the frontend.
    * experimental
    */
    public io.netty.util.concurrent.Future screencastFrameAck(jpuppeteer.cdp.client.entity.page.ScreencastFrameAckRequest request) {
        return session.send("Page.screencastFrameAck", request);
    }


    /**
    * Searches for given string in resource content.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.page.SearchInResourceResponse> searchInResource(jpuppeteer.cdp.client.entity.page.SearchInResourceRequest request) {
        return session.send("Page.searchInResource", request, jpuppeteer.cdp.client.entity.page.SearchInResourceResponse.class);
    }


    /**
    * Enable Chrome's experimental ad filter on all sites.
    * experimental
    */
    public io.netty.util.concurrent.Future setAdBlockingEnabled(jpuppeteer.cdp.client.entity.page.SetAdBlockingEnabledRequest request) {
        return session.send("Page.setAdBlockingEnabled", request);
    }


    /**
    * Enable page Content Security Policy by-passing.
    * experimental
    */
    public io.netty.util.concurrent.Future setBypassCSP(jpuppeteer.cdp.client.entity.page.SetBypassCSPRequest request) {
        return session.send("Page.setBypassCSP", request);
    }


    /**
    * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setDeviceMetricsOverride(jpuppeteer.cdp.client.entity.page.SetDeviceMetricsOverrideRequest request) {
        return session.send("Page.setDeviceMetricsOverride", request);
    }


    /**
    * Overrides the Device Orientation.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setDeviceOrientationOverride(jpuppeteer.cdp.client.entity.page.SetDeviceOrientationOverrideRequest request) {
        return session.send("Page.setDeviceOrientationOverride", request);
    }


    /**
    * Set generic font families.
    * experimental
    */
    public io.netty.util.concurrent.Future setFontFamilies(jpuppeteer.cdp.client.entity.page.SetFontFamiliesRequest request) {
        return session.send("Page.setFontFamilies", request);
    }


    /**
    * Set default font sizes.
    * experimental
    */
    public io.netty.util.concurrent.Future setFontSizes(jpuppeteer.cdp.client.entity.page.SetFontSizesRequest request) {
        return session.send("Page.setFontSizes", request);
    }


    /**
    * Sets given markup as the document's HTML.
    */
    public io.netty.util.concurrent.Future setDocumentContent(jpuppeteer.cdp.client.entity.page.SetDocumentContentRequest request) {
        return session.send("Page.setDocumentContent", request);
    }


    /**
    * Set the behavior when downloading a file.
    * experimental
    */
    public io.netty.util.concurrent.Future setDownloadBehavior(jpuppeteer.cdp.client.entity.page.SetDownloadBehaviorRequest request) {
        return session.send("Page.setDownloadBehavior", request);
    }


    /**
    * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setGeolocationOverride(jpuppeteer.cdp.client.entity.page.SetGeolocationOverrideRequest request) {
        return session.send("Page.setGeolocationOverride", request);
    }


    /**
    * Controls whether page will emit lifecycle events.
    * experimental
    */
    public io.netty.util.concurrent.Future setLifecycleEventsEnabled(jpuppeteer.cdp.client.entity.page.SetLifecycleEventsEnabledRequest request) {
        return session.send("Page.setLifecycleEventsEnabled", request);
    }


    /**
    * Toggles mouse event-based touch event emulation.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setTouchEmulationEnabled(jpuppeteer.cdp.client.entity.page.SetTouchEmulationEnabledRequest request) {
        return session.send("Page.setTouchEmulationEnabled", request);
    }


    /**
    * Starts sending each frame using the `screencastFrame` event.
    * experimental
    */
    public io.netty.util.concurrent.Future startScreencast(jpuppeteer.cdp.client.entity.page.StartScreencastRequest request) {
        return session.send("Page.startScreencast", request);
    }


    /**
    * Force the page stop all navigations and pending resource fetches.
    */
    public io.netty.util.concurrent.Future stopLoading() {
        return session.send("Page.stopLoading", null);
    }


    /**
    * Crashes renderer on the IO thread, generates minidumps.
    * experimental
    */
    public io.netty.util.concurrent.Future crash() {
        return session.send("Page.crash", null);
    }


    /**
    * Tries to close page, running its beforeunload hooks, if any.
    * experimental
    */
    public io.netty.util.concurrent.Future close() {
        return session.send("Page.close", null);
    }


    /**
    * Tries to update the web lifecycle state of the page. It will transition the page to the given state according to: https://github.com/WICG/web-lifecycle/
    * experimental
    */
    public io.netty.util.concurrent.Future setWebLifecycleState(jpuppeteer.cdp.client.entity.page.SetWebLifecycleStateRequest request) {
        return session.send("Page.setWebLifecycleState", request);
    }


    /**
    * Stops sending each frame in the `screencastFrame`.
    * experimental
    */
    public io.netty.util.concurrent.Future stopScreencast() {
        return session.send("Page.stopScreencast", null);
    }


    /**
    * Forces compilation cache to be generated for every subresource script.
    * experimental
    */
    public io.netty.util.concurrent.Future setProduceCompilationCache(jpuppeteer.cdp.client.entity.page.SetProduceCompilationCacheRequest request) {
        return session.send("Page.setProduceCompilationCache", request);
    }


    /**
    * Seeds compilation cache for given url. Compilation cache does not survive cross-process navigation.
    * experimental
    */
    public io.netty.util.concurrent.Future addCompilationCache(jpuppeteer.cdp.client.entity.page.AddCompilationCacheRequest request) {
        return session.send("Page.addCompilationCache", request);
    }


    /**
    * Clears seeded compilation cache.
    * experimental
    */
    public io.netty.util.concurrent.Future clearCompilationCache() {
        return session.send("Page.clearCompilationCache", null);
    }


    /**
    * Generates a report for testing.
    * experimental
    */
    public io.netty.util.concurrent.Future generateTestReport(jpuppeteer.cdp.client.entity.page.GenerateTestReportRequest request) {
        return session.send("Page.generateTestReport", request);
    }


    /**
    * Pauses page execution. Can be resumed using generic Runtime.runIfWaitingForDebugger.
    * experimental
    */
    public io.netty.util.concurrent.Future waitForDebugger() {
        return session.send("Page.waitForDebugger", null);
    }


    /**
    * Intercept file chooser requests and transfer control to protocol clients. When file chooser interception is enabled, native file chooser dialog is not shown. Instead, a protocol event `Page.fileChooserOpened` is emitted.
    * experimental
    */
    public io.netty.util.concurrent.Future setInterceptFileChooserDialog(jpuppeteer.cdp.client.entity.page.SetInterceptFileChooserDialogRequest request) {
        return session.send("Page.setInterceptFileChooserDialog", request);
    }

}