package jpuppeteer.cdp.client.domain;

/**
*/
public class Profiler {

    private jpuppeteer.cdp.CDPConnection connection;

    public Profiler(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("Profiler.disable", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("Profiler.enable", null);
    }


    /**
    * Collect coverage data for the current isolate. The coverage data may be incomplete due to garbage collection.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.profiler.GetBestEffortCoverageResponse> getBestEffortCoverage() {
        return connection.send("Profiler.getBestEffortCoverage", null, jpuppeteer.cdp.client.entity.profiler.GetBestEffortCoverageResponse.class);
    }


    /**
    * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
    */
    public jpuppeteer.util.XFuture<?> setSamplingInterval(jpuppeteer.cdp.client.entity.profiler.SetSamplingIntervalRequest request) {
        return connection.send("Profiler.setSamplingInterval", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> start() {
        return connection.send("Profiler.start", null);
    }


    /**
    * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code coverage may be incomplete. Enabling prevents running optimized code and resets execution counters.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.profiler.StartPreciseCoverageResponse> startPreciseCoverage(jpuppeteer.cdp.client.entity.profiler.StartPreciseCoverageRequest request) {
        return connection.send("Profiler.startPreciseCoverage", request, jpuppeteer.cdp.client.entity.profiler.StartPreciseCoverageResponse.class);
    }


    /**
    * Enable type profile.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> startTypeProfile() {
        return connection.send("Profiler.startTypeProfile", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.profiler.StopResponse> stop() {
        return connection.send("Profiler.stop", null, jpuppeteer.cdp.client.entity.profiler.StopResponse.class);
    }


    /**
    * Disable precise code coverage. Disabling releases unnecessary execution count records and allows executing optimized code.
    */
    public jpuppeteer.util.XFuture<?> stopPreciseCoverage() {
        return connection.send("Profiler.stopPreciseCoverage", null);
    }


    /**
    * Disable type profile. Disabling releases type profile data collected so far.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> stopTypeProfile() {
        return connection.send("Profiler.stopTypeProfile", null);
    }


    /**
    * Collect coverage data for the current isolate, and resets execution counters. Precise code coverage needs to have started.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.profiler.TakePreciseCoverageResponse> takePreciseCoverage() {
        return connection.send("Profiler.takePreciseCoverage", null, jpuppeteer.cdp.client.entity.profiler.TakePreciseCoverageResponse.class);
    }


    /**
    * Collect type profile.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.profiler.TakeTypeProfileResponse> takeTypeProfile() {
        return connection.send("Profiler.takeTypeProfile", null, jpuppeteer.cdp.client.entity.profiler.TakeTypeProfileResponse.class);
    }


    /**
    * Enable counters collection.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> enableCounters() {
        return connection.send("Profiler.enableCounters", null);
    }


    /**
    * Disable counters collection.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> disableCounters() {
        return connection.send("Profiler.disableCounters", null);
    }


    /**
    * Retrieve counters.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.profiler.GetCountersResponse> getCounters() {
        return connection.send("Profiler.getCounters", null, jpuppeteer.cdp.client.entity.profiler.GetCountersResponse.class);
    }


    /**
    * Enable run time call stats collection.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> enableRuntimeCallStats() {
        return connection.send("Profiler.enableRuntimeCallStats", null);
    }


    /**
    * Disable run time call stats collection.
    * experimental
    */
    public jpuppeteer.util.XFuture<?> disableRuntimeCallStats() {
        return connection.send("Profiler.disableRuntimeCallStats", null);
    }


    /**
    * Retrieve run time call stats.
    * experimental
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.profiler.GetRuntimeCallStatsResponse> getRuntimeCallStats() {
        return connection.send("Profiler.getRuntimeCallStats", null, jpuppeteer.cdp.client.entity.profiler.GetRuntimeCallStatsResponse.class);
    }

}