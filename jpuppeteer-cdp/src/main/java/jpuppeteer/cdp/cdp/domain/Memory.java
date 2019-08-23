package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class Memory {

    private jpuppeteer.cdp.CDPSession session;

    public Memory(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.memory.GetDOMCountersResponse getDOMCounters(int timeout) throws Exception {
        return session.send("Memory.getDOMCounters", null, jpuppeteer.cdp.cdp.entity.memory.GetDOMCountersResponse.class, timeout);
    }


    /**
    * experimental
    */
    public void prepareForLeakDetection(int timeout) throws Exception {
        session.send("Memory.prepareForLeakDetection", null, timeout);
    }


    /**
    * Simulate OomIntervention by purging V8 memory.
    * experimental
    */
    public void forciblyPurgeJavaScriptMemory(int timeout) throws Exception {
        session.send("Memory.forciblyPurgeJavaScriptMemory", null, timeout);
    }


    /**
    * Enable/disable suppressing memory pressure notifications in all processes.
    * experimental
    */
    public void setPressureNotificationsSuppressed(jpuppeteer.cdp.cdp.entity.memory.SetPressureNotificationsSuppressedRequest request, int timeout) throws Exception {
        session.send("Memory.setPressureNotificationsSuppressed", request, timeout);
    }


    /**
    * Simulate a memory pressure notification in all processes.
    * experimental
    */
    public void simulatePressureNotification(jpuppeteer.cdp.cdp.entity.memory.SimulatePressureNotificationRequest request, int timeout) throws Exception {
        session.send("Memory.simulatePressureNotification", request, timeout);
    }


    /**
    * Start collecting native memory profile.
    * experimental
    */
    public void startSampling(jpuppeteer.cdp.cdp.entity.memory.StartSamplingRequest request, int timeout) throws Exception {
        session.send("Memory.startSampling", request, timeout);
    }


    /**
    * Stop collecting native memory profile.
    * experimental
    */
    public void stopSampling(int timeout) throws Exception {
        session.send("Memory.stopSampling", null, timeout);
    }


    /**
    * Retrieve native memory allocations profile collected since renderer process startup.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.memory.GetAllTimeSamplingProfileResponse getAllTimeSamplingProfile(int timeout) throws Exception {
        return session.send("Memory.getAllTimeSamplingProfile", null, jpuppeteer.cdp.cdp.entity.memory.GetAllTimeSamplingProfileResponse.class, timeout);
    }


    /**
    * Retrieve native memory allocations profile collected since browser process startup.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.memory.GetBrowserSamplingProfileResponse getBrowserSamplingProfile(int timeout) throws Exception {
        return session.send("Memory.getBrowserSamplingProfile", null, jpuppeteer.cdp.cdp.entity.memory.GetBrowserSamplingProfileResponse.class, timeout);
    }


    /**
    * Retrieve native memory allocations profile collected since last `startSampling` call.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.memory.GetSamplingProfileResponse getSamplingProfile(int timeout) throws Exception {
        return session.send("Memory.getSamplingProfile", null, jpuppeteer.cdp.cdp.entity.memory.GetSamplingProfileResponse.class, timeout);
    }

}