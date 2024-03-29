package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Memory {

    private jpuppeteer.cdp.CDPConnection connection;

    public Memory(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.memory.GetDOMCountersResponse> getDOMCounters() {
        return connection.send("Memory.getDOMCounters", null, jpuppeteer.cdp.client.entity.memory.GetDOMCountersResponse.class);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> prepareForLeakDetection() {
        return connection.send("Memory.prepareForLeakDetection", null);
    }


    /**
    * Simulate OomIntervention by purging V8 memory.
    */
    public jpuppeteer.util.XFuture<?> forciblyPurgeJavaScriptMemory() {
        return connection.send("Memory.forciblyPurgeJavaScriptMemory", null);
    }


    /**
    * Enable/disable suppressing memory pressure notifications in all processes.
    */
    public jpuppeteer.util.XFuture<?> setPressureNotificationsSuppressed(jpuppeteer.cdp.client.entity.memory.SetPressureNotificationsSuppressedRequest request) {
        return connection.send("Memory.setPressureNotificationsSuppressed", request);
    }


    /**
    * Simulate a memory pressure notification in all processes.
    */
    public jpuppeteer.util.XFuture<?> simulatePressureNotification(jpuppeteer.cdp.client.entity.memory.SimulatePressureNotificationRequest request) {
        return connection.send("Memory.simulatePressureNotification", request);
    }


    /**
    * Start collecting native memory profile.
    */
    public jpuppeteer.util.XFuture<?> startSampling(jpuppeteer.cdp.client.entity.memory.StartSamplingRequest request) {
        return connection.send("Memory.startSampling", request);
    }


    /**
    * Stop collecting native memory profile.
    */
    public jpuppeteer.util.XFuture<?> stopSampling() {
        return connection.send("Memory.stopSampling", null);
    }


    /**
    * Retrieve native memory allocations profile collected since renderer process startup.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.memory.GetAllTimeSamplingProfileResponse> getAllTimeSamplingProfile() {
        return connection.send("Memory.getAllTimeSamplingProfile", null, jpuppeteer.cdp.client.entity.memory.GetAllTimeSamplingProfileResponse.class);
    }


    /**
    * Retrieve native memory allocations profile collected since browser process startup.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.memory.GetBrowserSamplingProfileResponse> getBrowserSamplingProfile() {
        return connection.send("Memory.getBrowserSamplingProfile", null, jpuppeteer.cdp.client.entity.memory.GetBrowserSamplingProfileResponse.class);
    }


    /**
    * Retrieve native memory allocations profile collected since last `startSampling` call.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.memory.GetSamplingProfileResponse> getSamplingProfile() {
        return connection.send("Memory.getSamplingProfile", null, jpuppeteer.cdp.client.entity.memory.GetSamplingProfileResponse.class);
    }

}