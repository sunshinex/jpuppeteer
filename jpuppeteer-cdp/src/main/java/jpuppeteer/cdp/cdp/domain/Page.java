package jpuppeteer.cdp.cdp.domain;

/**
*/
public class Page {

    private jpuppeteer.cdp.CDPSession session;

    public Page(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Deprecated, please use addScriptToEvaluateOnNewDocument instead.
    */
    public jpuppeteer.cdp.cdp.entity.page.AddScriptToEvaluateOnLoadResponse addScriptToEvaluateOnLoad(jpuppeteer.cdp.cdp.entity.page.AddScriptToEvaluateOnLoadRequest request, int timeout) throws Exception {
        return session.send("Page.addScriptToEvaluateOnLoad", request, jpuppeteer.cdp.cdp.entity.page.AddScriptToEvaluateOnLoadResponse.class, timeout);
    }


    /**
    * Evaluates given script in every frame upon creation (before loading frame's scripts).
    */
    public jpuppeteer.cdp.cdp.entity.page.AddScriptToEvaluateOnNewDocumentResponse addScriptToEvaluateOnNewDocument(jpuppeteer.cdp.cdp.entity.page.AddScriptToEvaluateOnNewDocumentRequest request, int timeout) throws Exception {
        return session.send("Page.addScriptToEvaluateOnNewDocument", request, jpuppeteer.cdp.cdp.entity.page.AddScriptToEvaluateOnNewDocumentResponse.class, timeout);
    }


    /**
    * Brings page to front (activates tab).
    */
    public void bringToFront(int timeout) throws Exception {
        session.send("Page.bringToFront", null, timeout);
    }


    /**
    * Capture page screenshot.
    */
    public jpuppeteer.cdp.cdp.entity.page.CaptureScreenshotResponse captureScreenshot(jpuppeteer.cdp.cdp.entity.page.CaptureScreenshotRequest request, int timeout) throws Exception {
        return session.send("Page.captureScreenshot", request, jpuppeteer.cdp.cdp.entity.page.CaptureScreenshotResponse.class, timeout);
    }


    /**
    * Returns a snapshot of the page as a string. For MHTML format, the serialization includes iframes, shadow DOM, external resources, and element-inline styles.
    */
    public jpuppeteer.cdp.cdp.entity.page.CaptureSnapshotResponse captureSnapshot(jpuppeteer.cdp.cdp.entity.page.CaptureSnapshotRequest request, int timeout) throws Exception {
        return session.send("Page.captureSnapshot", request, jpuppeteer.cdp.cdp.entity.page.CaptureSnapshotResponse.class, timeout);
    }


    /**
    * Clears the overriden device metrics.
    */
    public void clearDeviceMetricsOverride(int timeout) throws Exception {
        session.send("Page.clearDeviceMetricsOverride", null, timeout);
    }


    /**
    * Clears the overridden Device Orientation.
    */
    public void clearDeviceOrientationOverride(int timeout) throws Exception {
        session.send("Page.clearDeviceOrientationOverride", null, timeout);
    }


    /**
    * Clears the overriden Geolocation Position and Error.
    */
    public void clearGeolocationOverride(int timeout) throws Exception {
        session.send("Page.clearGeolocationOverride", null, timeout);
    }


    /**
    * Creates an isolated world for the given frame.
    */
    public jpuppeteer.cdp.cdp.entity.page.CreateIsolatedWorldResponse createIsolatedWorld(jpuppeteer.cdp.cdp.entity.page.CreateIsolatedWorldRequest request, int timeout) throws Exception {
        return session.send("Page.createIsolatedWorld", request, jpuppeteer.cdp.cdp.entity.page.CreateIsolatedWorldResponse.class, timeout);
    }


    /**
    * Deletes browser cookie with given name, domain and path.
    */
    public void deleteCookie(jpuppeteer.cdp.cdp.entity.page.DeleteCookieRequest request, int timeout) throws Exception {
        session.send("Page.deleteCookie", request, timeout);
    }


    /**
    * Disables page domain notifications.
    */
    public void disable(int timeout) throws Exception {
        session.send("Page.disable", null, timeout);
    }


    /**
    * Enables page domain notifications.
    */
    public void enable(int timeout) throws Exception {
        session.send("Page.enable", null, timeout);
    }


    /**
    */
    public jpuppeteer.cdp.cdp.entity.page.GetAppManifestResponse getAppManifest(int timeout) throws Exception {
        return session.send("Page.getAppManifest", null, jpuppeteer.cdp.cdp.entity.page.GetAppManifestResponse.class, timeout);
    }


    /**
    */
    public jpuppeteer.cdp.cdp.entity.page.GetInstallabilityErrorsResponse getInstallabilityErrors(int timeout) throws Exception {
        return session.send("Page.getInstallabilityErrors", null, jpuppeteer.cdp.cdp.entity.page.GetInstallabilityErrorsResponse.class, timeout);
    }


    /**
    * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the `cookies` field.
    */
    public jpuppeteer.cdp.cdp.entity.page.GetCookiesResponse getCookies(int timeout) throws Exception {
        return session.send("Page.getCookies", null, jpuppeteer.cdp.cdp.entity.page.GetCookiesResponse.class, timeout);
    }


    /**
    * Returns present frame tree structure.
    */
    public jpuppeteer.cdp.cdp.entity.page.GetFrameTreeResponse getFrameTree(int timeout) throws Exception {
        return session.send("Page.getFrameTree", null, jpuppeteer.cdp.cdp.entity.page.GetFrameTreeResponse.class, timeout);
    }


    /**
    * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
    */
    public jpuppeteer.cdp.cdp.entity.page.GetLayoutMetricsResponse getLayoutMetrics(int timeout) throws Exception {
        return session.send("Page.getLayoutMetrics", null, jpuppeteer.cdp.cdp.entity.page.GetLayoutMetricsResponse.class, timeout);
    }


    /**
    * Returns navigation history for the current page.
    */
    public jpuppeteer.cdp.cdp.entity.page.GetNavigationHistoryResponse getNavigationHistory(int timeout) throws Exception {
        return session.send("Page.getNavigationHistory", null, jpuppeteer.cdp.cdp.entity.page.GetNavigationHistoryResponse.class, timeout);
    }


    /**
    * Resets navigation history for the current page.
    */
    public void resetNavigationHistory(int timeout) throws Exception {
        session.send("Page.resetNavigationHistory", null, timeout);
    }


    /**
    * Returns content of the given resource.
    */
    public jpuppeteer.cdp.cdp.entity.page.GetResourceContentResponse getResourceContent(jpuppeteer.cdp.cdp.entity.page.GetResourceContentRequest request, int timeout) throws Exception {
        return session.send("Page.getResourceContent", request, jpuppeteer.cdp.cdp.entity.page.GetResourceContentResponse.class, timeout);
    }


    /**
    * Returns present frame / resource tree structure.
    */
    public jpuppeteer.cdp.cdp.entity.page.GetResourceTreeResponse getResourceTree(int timeout) throws Exception {
        return session.send("Page.getResourceTree", null, jpuppeteer.cdp.cdp.entity.page.GetResourceTreeResponse.class, timeout);
    }


    /**
    * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
    */
    public void handleJavaScriptDialog(jpuppeteer.cdp.cdp.entity.page.HandleJavaScriptDialogRequest request, int timeout) throws Exception {
        session.send("Page.handleJavaScriptDialog", request, timeout);
    }


    /**
    * Navigates current page to the given URL.
    */
    public jpuppeteer.cdp.cdp.entity.page.NavigateResponse navigate(jpuppeteer.cdp.cdp.entity.page.NavigateRequest request, int timeout) throws Exception {
        return session.send("Page.navigate", request, jpuppeteer.cdp.cdp.entity.page.NavigateResponse.class, timeout);
    }


    /**
    * Navigates current page to the given history entry.
    */
    public void navigateToHistoryEntry(jpuppeteer.cdp.cdp.entity.page.NavigateToHistoryEntryRequest request, int timeout) throws Exception {
        session.send("Page.navigateToHistoryEntry", request, timeout);
    }


    /**
    * Print page as PDF.
    */
    public jpuppeteer.cdp.cdp.entity.page.PrintToPDFResponse printToPDF(jpuppeteer.cdp.cdp.entity.page.PrintToPDFRequest request, int timeout) throws Exception {
        return session.send("Page.printToPDF", request, jpuppeteer.cdp.cdp.entity.page.PrintToPDFResponse.class, timeout);
    }


    /**
    * Reloads given page optionally ignoring the cache.
    */
    public void reload(jpuppeteer.cdp.cdp.entity.page.ReloadRequest request, int timeout) throws Exception {
        session.send("Page.reload", request, timeout);
    }


    /**
    * Deprecated, please use removeScriptToEvaluateOnNewDocument instead.
    */
    public void removeScriptToEvaluateOnLoad(jpuppeteer.cdp.cdp.entity.page.RemoveScriptToEvaluateOnLoadRequest request, int timeout) throws Exception {
        session.send("Page.removeScriptToEvaluateOnLoad", request, timeout);
    }


    /**
    * Removes given script from the list.
    */
    public void removeScriptToEvaluateOnNewDocument(jpuppeteer.cdp.cdp.entity.page.RemoveScriptToEvaluateOnNewDocumentRequest request, int timeout) throws Exception {
        session.send("Page.removeScriptToEvaluateOnNewDocument", request, timeout);
    }


    /**
    * Acknowledges that a screencast frame has been received by the frontend.
    */
    public void screencastFrameAck(jpuppeteer.cdp.cdp.entity.page.ScreencastFrameAckRequest request, int timeout) throws Exception {
        session.send("Page.screencastFrameAck", request, timeout);
    }


    /**
    * Searches for given string in resource content.
    */
    public jpuppeteer.cdp.cdp.entity.page.SearchInResourceResponse searchInResource(jpuppeteer.cdp.cdp.entity.page.SearchInResourceRequest request, int timeout) throws Exception {
        return session.send("Page.searchInResource", request, jpuppeteer.cdp.cdp.entity.page.SearchInResourceResponse.class, timeout);
    }


    /**
    * Enable Chrome's experimental ad filter on all sites.
    */
    public void setAdBlockingEnabled(jpuppeteer.cdp.cdp.entity.page.SetAdBlockingEnabledRequest request, int timeout) throws Exception {
        session.send("Page.setAdBlockingEnabled", request, timeout);
    }


    /**
    * Enable page Content Security Policy by-passing.
    */
    public void setBypassCSP(jpuppeteer.cdp.cdp.entity.page.SetBypassCSPRequest request, int timeout) throws Exception {
        session.send("Page.setBypassCSP", request, timeout);
    }


    /**
    * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
    */
    public void setDeviceMetricsOverride(jpuppeteer.cdp.cdp.entity.page.SetDeviceMetricsOverrideRequest request, int timeout) throws Exception {
        session.send("Page.setDeviceMetricsOverride", request, timeout);
    }


    /**
    * Overrides the Device Orientation.
    */
    public void setDeviceOrientationOverride(jpuppeteer.cdp.cdp.entity.page.SetDeviceOrientationOverrideRequest request, int timeout) throws Exception {
        session.send("Page.setDeviceOrientationOverride", request, timeout);
    }


    /**
    * Set generic font families.
    */
    public void setFontFamilies(jpuppeteer.cdp.cdp.entity.page.SetFontFamiliesRequest request, int timeout) throws Exception {
        session.send("Page.setFontFamilies", request, timeout);
    }


    /**
    * Set default font sizes.
    */
    public void setFontSizes(jpuppeteer.cdp.cdp.entity.page.SetFontSizesRequest request, int timeout) throws Exception {
        session.send("Page.setFontSizes", request, timeout);
    }


    /**
    * Sets given markup as the document's HTML.
    */
    public void setDocumentContent(jpuppeteer.cdp.cdp.entity.page.SetDocumentContentRequest request, int timeout) throws Exception {
        session.send("Page.setDocumentContent", request, timeout);
    }


    /**
    * Set the behavior when downloading a file.
    */
    public void setDownloadBehavior(jpuppeteer.cdp.cdp.entity.page.SetDownloadBehaviorRequest request, int timeout) throws Exception {
        session.send("Page.setDownloadBehavior", request, timeout);
    }


    /**
    * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
    */
    public void setGeolocationOverride(jpuppeteer.cdp.cdp.entity.page.SetGeolocationOverrideRequest request, int timeout) throws Exception {
        session.send("Page.setGeolocationOverride", request, timeout);
    }


    /**
    * Controls whether page will emit lifecycle events.
    */
    public void setLifecycleEventsEnabled(jpuppeteer.cdp.cdp.entity.page.SetLifecycleEventsEnabledRequest request, int timeout) throws Exception {
        session.send("Page.setLifecycleEventsEnabled", request, timeout);
    }


    /**
    * Toggles mouse event-based touch event emulation.
    */
    public void setTouchEmulationEnabled(jpuppeteer.cdp.cdp.entity.page.SetTouchEmulationEnabledRequest request, int timeout) throws Exception {
        session.send("Page.setTouchEmulationEnabled", request, timeout);
    }


    /**
    * Starts sending each frame using the `screencastFrame` event.
    */
    public void startScreencast(jpuppeteer.cdp.cdp.entity.page.StartScreencastRequest request, int timeout) throws Exception {
        session.send("Page.startScreencast", request, timeout);
    }


    /**
    * Force the page stop all navigations and pending resource fetches.
    */
    public void stopLoading(int timeout) throws Exception {
        session.send("Page.stopLoading", null, timeout);
    }


    /**
    * Crashes renderer on the IO thread, generates minidumps.
    */
    public void crash(int timeout) throws Exception {
        session.send("Page.crash", null, timeout);
    }


    /**
    * Tries to close page, running its beforeunload hooks, if any.
    */
    public void close(int timeout) throws Exception {
        session.send("Page.close", null, timeout);
    }


    /**
    * Tries to update the web lifecycle state of the page. It will transition the page to the given state according to: https://github.com/WICG/web-lifecycle/
    */
    public void setWebLifecycleState(jpuppeteer.cdp.cdp.entity.page.SetWebLifecycleStateRequest request, int timeout) throws Exception {
        session.send("Page.setWebLifecycleState", request, timeout);
    }


    /**
    * Stops sending each frame in the `screencastFrame`.
    */
    public void stopScreencast(int timeout) throws Exception {
        session.send("Page.stopScreencast", null, timeout);
    }


    /**
    * Forces compilation cache to be generated for every subresource script.
    */
    public void setProduceCompilationCache(jpuppeteer.cdp.cdp.entity.page.SetProduceCompilationCacheRequest request, int timeout) throws Exception {
        session.send("Page.setProduceCompilationCache", request, timeout);
    }


    /**
    * Seeds compilation cache for given url. Compilation cache does not survive cross-process navigation.
    */
    public void addCompilationCache(jpuppeteer.cdp.cdp.entity.page.AddCompilationCacheRequest request, int timeout) throws Exception {
        session.send("Page.addCompilationCache", request, timeout);
    }


    /**
    * Clears seeded compilation cache.
    */
    public void clearCompilationCache(int timeout) throws Exception {
        session.send("Page.clearCompilationCache", null, timeout);
    }


    /**
    * Generates a report for testing.
    */
    public void generateTestReport(jpuppeteer.cdp.cdp.entity.page.GenerateTestReportRequest request, int timeout) throws Exception {
        session.send("Page.generateTestReport", request, timeout);
    }


    /**
    * Pauses page execution. Can be resumed using generic Runtime.runIfWaitingForDebugger.
    */
    public void waitForDebugger(int timeout) throws Exception {
        session.send("Page.waitForDebugger", null, timeout);
    }


    /**
    * Intercept file chooser requests and transfer control to protocol clients. When file chooser interception is enabled, native file chooser dialog is not shown. Instead, a protocol event `Page.fileChooserOpened` is emitted. File chooser can be handled with `page.handleFileChooser` command.
    */
    public void setInterceptFileChooserDialog(jpuppeteer.cdp.cdp.entity.page.SetInterceptFileChooserDialogRequest request, int timeout) throws Exception {
        session.send("Page.setInterceptFileChooserDialog", request, timeout);
    }


    /**
    * Accepts or cancels an intercepted file chooser dialog.
    */
    public void handleFileChooser(jpuppeteer.cdp.cdp.entity.page.HandleFileChooserRequest request, int timeout) throws Exception {
        session.send("Page.handleFileChooser", request, timeout);
    }

}