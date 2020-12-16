package jpuppeteer.cdp.client.domain;

/**
*/
public class Profiler {

    private jpuppeteer.cdp.CDPSession session;

    public Profiler(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("Profiler.disable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("Profiler.enable", null);
    }


    /**
    * Collect coverage data for the current isolate. The coverage data may be incomplete due to garbage collection.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.profiler.GetBestEffortCoverageResponse> getBestEffortCoverage() {
        return session.send("Profiler.getBestEffortCoverage", null, jpuppeteer.cdp.client.entity.profiler.GetBestEffortCoverageResponse.class);
    }


    /**
    * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
    */
    public io.netty.util.concurrent.Future setSamplingInterval(jpuppeteer.cdp.client.entity.profiler.SetSamplingIntervalRequest request) {
        return session.send("Profiler.setSamplingInterval", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future start() {
        return session.send("Profiler.start", null);
    }


    /**
    * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code coverage may be incomplete. Enabling prevents running optimized code and resets execution counters.
    */
    public io.netty.util.concurrent.Future startPreciseCoverage(jpuppeteer.cdp.client.entity.profiler.StartPreciseCoverageRequest request) {
        return session.send("Profiler.startPreciseCoverage", request);
    }


    /**
    * Enable type profile.
    * experimental
    */
    public io.netty.util.concurrent.Future startTypeProfile() {
        return session.send("Profiler.startTypeProfile", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.profiler.StopResponse> stop() {
        return session.send("Profiler.stop", null, jpuppeteer.cdp.client.entity.profiler.StopResponse.class);
    }


    /**
    * Disable precise code coverage. Disabling releases unnecessary execution count records and allows executing optimized code.
    */
    public io.netty.util.concurrent.Future stopPreciseCoverage() {
        return session.send("Profiler.stopPreciseCoverage", null);
    }


    /**
    * Disable type profile. Disabling releases type profile data collected so far.
    * experimental
    */
    public io.netty.util.concurrent.Future stopTypeProfile() {
        return session.send("Profiler.stopTypeProfile", null);
    }


    /**
    * Collect coverage data for the current isolate, and resets execution counters. Precise code coverage needs to have started.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.profiler.TakePreciseCoverageResponse> takePreciseCoverage() {
        return session.send("Profiler.takePreciseCoverage", null, jpuppeteer.cdp.client.entity.profiler.TakePreciseCoverageResponse.class);
    }


    /**
    * Collect type profile.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.profiler.TakeTypeProfileResponse> takeTypeProfile() {
        return session.send("Profiler.takeTypeProfile", null, jpuppeteer.cdp.client.entity.profiler.TakeTypeProfileResponse.class);
    }


    /**
    * Enable run time call stats collection.
    * experimental
    */
    public io.netty.util.concurrent.Future enableRuntimeCallStats() {
        return session.send("Profiler.enableRuntimeCallStats", null);
    }


    /**
    * Disable run time call stats collection.
    * experimental
    */
    public io.netty.util.concurrent.Future disableRuntimeCallStats() {
        return session.send("Profiler.disableRuntimeCallStats", null);
    }


    /**
    * Retrieve run time call stats.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.profiler.GetRuntimeCallStatsResponse> getRuntimeCallStats() {
        return session.send("Profiler.getRuntimeCallStats", null, jpuppeteer.cdp.client.entity.profiler.GetRuntimeCallStatsResponse.class);
    }

}