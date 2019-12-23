package jpuppeteer.cdp.cdp.domain;

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
    public jpuppeteer.cdp.cdp.entity.emulation.CanEmulateResponse canEmulate(int timeout) throws Exception {
        return session.send("Emulation.canEmulate", null, jpuppeteer.cdp.cdp.entity.emulation.CanEmulateResponse.class, timeout);
    }


    /**
    * Clears the overriden device metrics.
    */
    public void clearDeviceMetricsOverride(int timeout) throws Exception {
        session.send("Emulation.clearDeviceMetricsOverride", null, timeout);
    }


    /**
    * Clears the overriden Geolocation Position and Error.
    */
    public void clearGeolocationOverride(int timeout) throws Exception {
        session.send("Emulation.clearGeolocationOverride", null, timeout);
    }


    /**
    * Requests that page scale factor is reset to initial values.
    */
    public void resetPageScaleFactor(int timeout) throws Exception {
        session.send("Emulation.resetPageScaleFactor", null, timeout);
    }


    /**
    * Enables or disables simulating a focused and active page.
    */
    public void setFocusEmulationEnabled(jpuppeteer.cdp.cdp.entity.emulation.SetFocusEmulationEnabledRequest request, int timeout) throws Exception {
        session.send("Emulation.setFocusEmulationEnabled", request, timeout);
    }


    /**
    * Enables CPU throttling to emulate slow CPUs.
    */
    public void setCPUThrottlingRate(jpuppeteer.cdp.cdp.entity.emulation.SetCPUThrottlingRateRequest request, int timeout) throws Exception {
        session.send("Emulation.setCPUThrottlingRate", request, timeout);
    }


    /**
    * Sets or clears an override of the default background color of the frame. This override is used if the content does not specify one.
    */
    public void setDefaultBackgroundColorOverride(jpuppeteer.cdp.cdp.entity.emulation.SetDefaultBackgroundColorOverrideRequest request, int timeout) throws Exception {
        session.send("Emulation.setDefaultBackgroundColorOverride", request, timeout);
    }


    /**
    * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
    */
    public void setDeviceMetricsOverride(jpuppeteer.cdp.cdp.entity.emulation.SetDeviceMetricsOverrideRequest request, int timeout) throws Exception {
        session.send("Emulation.setDeviceMetricsOverride", request, timeout);
    }


    /**
    */
    public void setScrollbarsHidden(jpuppeteer.cdp.cdp.entity.emulation.SetScrollbarsHiddenRequest request, int timeout) throws Exception {
        session.send("Emulation.setScrollbarsHidden", request, timeout);
    }


    /**
    */
    public void setDocumentCookieDisabled(jpuppeteer.cdp.cdp.entity.emulation.SetDocumentCookieDisabledRequest request, int timeout) throws Exception {
        session.send("Emulation.setDocumentCookieDisabled", request, timeout);
    }


    /**
    */
    public void setEmitTouchEventsForMouse(jpuppeteer.cdp.cdp.entity.emulation.SetEmitTouchEventsForMouseRequest request, int timeout) throws Exception {
        session.send("Emulation.setEmitTouchEventsForMouse", request, timeout);
    }


    /**
    * Emulates the given media for CSS media queries.
    */
    public void setEmulatedMedia(jpuppeteer.cdp.cdp.entity.emulation.SetEmulatedMediaRequest request, int timeout) throws Exception {
        session.send("Emulation.setEmulatedMedia", request, timeout);
    }


    /**
    * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
    */
    public void setGeolocationOverride(jpuppeteer.cdp.cdp.entity.emulation.SetGeolocationOverrideRequest request, int timeout) throws Exception {
        session.send("Emulation.setGeolocationOverride", request, timeout);
    }


    /**
    * Overrides value returned by the javascript navigator object.
    */
    public void setNavigatorOverrides(jpuppeteer.cdp.cdp.entity.emulation.SetNavigatorOverridesRequest request, int timeout) throws Exception {
        session.send("Emulation.setNavigatorOverrides", request, timeout);
    }


    /**
    * Sets a specified page scale factor.
    */
    public void setPageScaleFactor(jpuppeteer.cdp.cdp.entity.emulation.SetPageScaleFactorRequest request, int timeout) throws Exception {
        session.send("Emulation.setPageScaleFactor", request, timeout);
    }


    /**
    * Switches script execution in the page.
    */
    public void setScriptExecutionDisabled(jpuppeteer.cdp.cdp.entity.emulation.SetScriptExecutionDisabledRequest request, int timeout) throws Exception {
        session.send("Emulation.setScriptExecutionDisabled", request, timeout);
    }


    /**
    * Enables touch on platforms which do not support them.
    */
    public void setTouchEmulationEnabled(jpuppeteer.cdp.cdp.entity.emulation.SetTouchEmulationEnabledRequest request, int timeout) throws Exception {
        session.send("Emulation.setTouchEmulationEnabled", request, timeout);
    }


    /**
    * Turns on virtual time for all frames (replacing real-time with a synthetic time source) and sets the current virtual time policy.  Note this supersedes any previous time budget.
    */
    public jpuppeteer.cdp.cdp.entity.emulation.SetVirtualTimePolicyResponse setVirtualTimePolicy(jpuppeteer.cdp.cdp.entity.emulation.SetVirtualTimePolicyRequest request, int timeout) throws Exception {
        return session.send("Emulation.setVirtualTimePolicy", request, jpuppeteer.cdp.cdp.entity.emulation.SetVirtualTimePolicyResponse.class, timeout);
    }


    /**
    * Overrides default host system timezone with the specified one.
    */
    public void setTimezoneOverride(jpuppeteer.cdp.cdp.entity.emulation.SetTimezoneOverrideRequest request, int timeout) throws Exception {
        session.send("Emulation.setTimezoneOverride", request, timeout);
    }


    /**
    * Resizes the frame/viewport of the page. Note that this does not affect the frame's container (e.g. browser window). Can be used to produce screenshots of the specified size. Not supported on Android.
    */
    public void setVisibleSize(jpuppeteer.cdp.cdp.entity.emulation.SetVisibleSizeRequest request, int timeout) throws Exception {
        session.send("Emulation.setVisibleSize", request, timeout);
    }


    /**
    * Allows overriding user agent with the given string.
    */
    public void setUserAgentOverride(jpuppeteer.cdp.cdp.entity.emulation.SetUserAgentOverrideRequest request, int timeout) throws Exception {
        session.send("Emulation.setUserAgentOverride", request, timeout);
    }

}