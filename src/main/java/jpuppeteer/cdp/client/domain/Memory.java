package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Memory {

    private jpuppeteer.cdp.CDPSession session;

    public Memory(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.memory.GetDOMCountersResponse> getDOMCounters() {
        return session.send("Memory.getDOMCounters", null, jpuppeteer.cdp.client.entity.memory.GetDOMCountersResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future prepareForLeakDetection() {
        return session.send("Memory.prepareForLeakDetection", null);
    }


    /**
    * Simulate OomIntervention by purging V8 memory.
    */
    public io.netty.util.concurrent.Future forciblyPurgeJavaScriptMemory() {
        return session.send("Memory.forciblyPurgeJavaScriptMemory", null);
    }


    /**
    * Enable/disable suppressing memory pressure notifications in all processes.
    */
    public io.netty.util.concurrent.Future setPressureNotificationsSuppressed(jpuppeteer.cdp.client.entity.memory.SetPressureNotificationsSuppressedRequest request) {
        return session.send("Memory.setPressureNotificationsSuppressed", request);
    }


    /**
    * Simulate a memory pressure notification in all processes.
    */
    public io.netty.util.concurrent.Future simulatePressureNotification(jpuppeteer.cdp.client.entity.memory.SimulatePressureNotificationRequest request) {
        return session.send("Memory.simulatePressureNotification", request);
    }


    /**
    * Start collecting native memory profile.
    */
    public io.netty.util.concurrent.Future startSampling(jpuppeteer.cdp.client.entity.memory.StartSamplingRequest request) {
        return session.send("Memory.startSampling", request);
    }


    /**
    * Stop collecting native memory profile.
    */
    public io.netty.util.concurrent.Future stopSampling() {
        return session.send("Memory.stopSampling", null);
    }


    /**
    * Retrieve native memory allocations profile collected since renderer process startup.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.memory.GetAllTimeSamplingProfileResponse> getAllTimeSamplingProfile() {
        return session.send("Memory.getAllTimeSamplingProfile", null, jpuppeteer.cdp.client.entity.memory.GetAllTimeSamplingProfileResponse.class);
    }


    /**
    * Retrieve native memory allocations profile collected since browser process startup.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.memory.GetBrowserSamplingProfileResponse> getBrowserSamplingProfile() {
        return session.send("Memory.getBrowserSamplingProfile", null, jpuppeteer.cdp.client.entity.memory.GetBrowserSamplingProfileResponse.class);
    }


    /**
    * Retrieve native memory allocations profile collected since last `startSampling` call.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.memory.GetSamplingProfileResponse> getSamplingProfile() {
        return session.send("Memory.getSamplingProfile", null, jpuppeteer.cdp.client.entity.memory.GetSamplingProfileResponse.class);
    }

}