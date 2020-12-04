package jpuppeteer.cdp.client.domain;

/**
*/
public class Emulation {

    private jpuppeteer.cdp.CDPSession session;

    public Emulation(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Tells whether emulation is supported.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.emulation.CanEmulateResponse> canEmulate() {
        return session.send("Emulation.canEmulate", null, jpuppeteer.cdp.client.entity.emulation.CanEmulateResponse.class);
    }


    /**
    * Clears the overriden device metrics.
    */
    public io.netty.util.concurrent.Future clearDeviceMetricsOverride() {
        return session.send("Emulation.clearDeviceMetricsOverride", null);
    }


    /**
    * Clears the overriden Geolocation Position and Error.
    */
    public io.netty.util.concurrent.Future clearGeolocationOverride() {
        return session.send("Emulation.clearGeolocationOverride", null);
    }


    /**
    * Requests that page scale factor is reset to initial values.
    * experimental
    */
    public io.netty.util.concurrent.Future resetPageScaleFactor() {
        return session.send("Emulation.resetPageScaleFactor", null);
    }


    /**
    * Enables or disables simulating a focused and active page.
    * experimental
    */
    public io.netty.util.concurrent.Future setFocusEmulationEnabled(jpuppeteer.cdp.client.entity.emulation.SetFocusEmulationEnabledRequest request) {
        return session.send("Emulation.setFocusEmulationEnabled", request);
    }


    /**
    * Enables CPU throttling to emulate slow CPUs.
    * experimental
    */
    public io.netty.util.concurrent.Future setCPUThrottlingRate(jpuppeteer.cdp.client.entity.emulation.SetCPUThrottlingRateRequest request) {
        return session.send("Emulation.setCPUThrottlingRate", request);
    }


    /**
    * Sets or clears an override of the default background color of the frame. This override is used if the content does not specify one.
    */
    public io.netty.util.concurrent.Future setDefaultBackgroundColorOverride(jpuppeteer.cdp.client.entity.emulation.SetDefaultBackgroundColorOverrideRequest request) {
        return session.send("Emulation.setDefaultBackgroundColorOverride", request);
    }


    /**
    * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
    */
    public io.netty.util.concurrent.Future setDeviceMetricsOverride(jpuppeteer.cdp.client.entity.emulation.SetDeviceMetricsOverrideRequest request) {
        return session.send("Emulation.setDeviceMetricsOverride", request);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future setScrollbarsHidden(jpuppeteer.cdp.client.entity.emulation.SetScrollbarsHiddenRequest request) {
        return session.send("Emulation.setScrollbarsHidden", request);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future setDocumentCookieDisabled(jpuppeteer.cdp.client.entity.emulation.SetDocumentCookieDisabledRequest request) {
        return session.send("Emulation.setDocumentCookieDisabled", request);
    }


    /**
    * experimental
    */
    public io.netty.util.concurrent.Future setEmitTouchEventsForMouse(jpuppeteer.cdp.client.entity.emulation.SetEmitTouchEventsForMouseRequest request) {
        return session.send("Emulation.setEmitTouchEventsForMouse", request);
    }


    /**
    * Emulates the given media type or media feature for CSS media queries.
    */
    public io.netty.util.concurrent.Future setEmulatedMedia(jpuppeteer.cdp.client.entity.emulation.SetEmulatedMediaRequest request) {
        return session.send("Emulation.setEmulatedMedia", request);
    }


    /**
    * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
    */
    public io.netty.util.concurrent.Future setGeolocationOverride(jpuppeteer.cdp.client.entity.emulation.SetGeolocationOverrideRequest request) {
        return session.send("Emulation.setGeolocationOverride", request);
    }


    /**
    * Overrides value returned by the javascript navigator object.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setNavigatorOverrides(jpuppeteer.cdp.client.entity.emulation.SetNavigatorOverridesRequest request) {
        return session.send("Emulation.setNavigatorOverrides", request);
    }


    /**
    * Sets a specified page scale factor.
    * experimental
    */
    public io.netty.util.concurrent.Future setPageScaleFactor(jpuppeteer.cdp.client.entity.emulation.SetPageScaleFactorRequest request) {
        return session.send("Emulation.setPageScaleFactor", request);
    }


    /**
    * Switches script execution in the page.
    */
    public io.netty.util.concurrent.Future setScriptExecutionDisabled(jpuppeteer.cdp.client.entity.emulation.SetScriptExecutionDisabledRequest request) {
        return session.send("Emulation.setScriptExecutionDisabled", request);
    }


    /**
    * Enables touch on platforms which do not support them.
    */
    public io.netty.util.concurrent.Future setTouchEmulationEnabled(jpuppeteer.cdp.client.entity.emulation.SetTouchEmulationEnabledRequest request) {
        return session.send("Emulation.setTouchEmulationEnabled", request);
    }


    /**
    * Turns on virtual time for all frames (replacing real-time with a synthetic time source) and sets the current virtual time policy.  Note this supersedes any previous time budget.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.emulation.SetVirtualTimePolicyResponse> setVirtualTimePolicy(jpuppeteer.cdp.client.entity.emulation.SetVirtualTimePolicyRequest request) {
        return session.send("Emulation.setVirtualTimePolicy", request, jpuppeteer.cdp.client.entity.emulation.SetVirtualTimePolicyResponse.class);
    }


    /**
    * Overrides default host system timezone with the specified one.
    * experimental
    */
    public io.netty.util.concurrent.Future setTimezoneOverride(jpuppeteer.cdp.client.entity.emulation.SetTimezoneOverrideRequest request) {
        return session.send("Emulation.setTimezoneOverride", request);
    }


    /**
    * Resizes the frame/viewport of the page. Note that this does not affect the frame's container (e.g. browser window). Can be used to produce screenshots of the specified size. Not supported on Android.
    * experimental
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future setVisibleSize(jpuppeteer.cdp.client.entity.emulation.SetVisibleSizeRequest request) {
        return session.send("Emulation.setVisibleSize", request);
    }


    /**
    * Allows overriding user agent with the given string.
    */
    public io.netty.util.concurrent.Future setUserAgentOverride(jpuppeteer.cdp.client.entity.emulation.SetUserAgentOverrideRequest request) {
        return session.send("Emulation.setUserAgentOverride", request);
    }

}