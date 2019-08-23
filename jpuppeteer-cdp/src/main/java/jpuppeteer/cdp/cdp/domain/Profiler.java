package jpuppeteer.cdp.cdp.domain;

/**
*/
public class Profiler {

    private jpuppeteer.cdp.CDPSession session;

    public Profiler(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    */
    public void disable(int timeout) throws Exception {
        session.send("Profiler.disable", null, timeout);
    }


    /**
    */
    public void enable(int timeout) throws Exception {
        session.send("Profiler.enable", null, timeout);
    }


    /**
    * Collect coverage data for the current isolate. The coverage data may be incomplete due to garbage collection.
    */
    public jpuppeteer.cdp.cdp.entity.profiler.GetBestEffortCoverageResponse getBestEffortCoverage(int timeout) throws Exception {
        return session.send("Profiler.getBestEffortCoverage", null, jpuppeteer.cdp.cdp.entity.profiler.GetBestEffortCoverageResponse.class, timeout);
    }


    /**
    * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
    */
    public void setSamplingInterval(jpuppeteer.cdp.cdp.entity.profiler.SetSamplingIntervalRequest request, int timeout) throws Exception {
        session.send("Profiler.setSamplingInterval", request, timeout);
    }


    /**
    */
    public void start(int timeout) throws Exception {
        session.send("Profiler.start", null, timeout);
    }


    /**
    * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code coverage may be incomplete. Enabling prevents running optimized code and resets execution counters.
    */
    public void startPreciseCoverage(jpuppeteer.cdp.cdp.entity.profiler.StartPreciseCoverageRequest request, int timeout) throws Exception {
        session.send("Profiler.startPreciseCoverage", request, timeout);
    }


    /**
    * Enable type profile.
    */
    public void startTypeProfile(int timeout) throws Exception {
        session.send("Profiler.startTypeProfile", null, timeout);
    }


    /**
    */
    public jpuppeteer.cdp.cdp.entity.profiler.StopResponse stop(int timeout) throws Exception {
        return session.send("Profiler.stop", null, jpuppeteer.cdp.cdp.entity.profiler.StopResponse.class, timeout);
    }


    /**
    * Disable precise code coverage. Disabling releases unnecessary execution count records and allows executing optimized code.
    */
    public void stopPreciseCoverage(int timeout) throws Exception {
        session.send("Profiler.stopPreciseCoverage", null, timeout);
    }


    /**
    * Disable type profile. Disabling releases type profile data collected so far.
    */
    public void stopTypeProfile(int timeout) throws Exception {
        session.send("Profiler.stopTypeProfile", null, timeout);
    }


    /**
    * Collect coverage data for the current isolate, and resets execution counters. Precise code coverage needs to have started.
    */
    public jpuppeteer.cdp.cdp.entity.profiler.TakePreciseCoverageResponse takePreciseCoverage(int timeout) throws Exception {
        return session.send("Profiler.takePreciseCoverage", null, jpuppeteer.cdp.cdp.entity.profiler.TakePreciseCoverageResponse.class, timeout);
    }


    /**
    * Collect type profile.
    */
    public jpuppeteer.cdp.cdp.entity.profiler.TakeTypeProfileResponse takeTypeProfile(int timeout) throws Exception {
        return session.send("Profiler.takeTypeProfile", null, jpuppeteer.cdp.cdp.entity.profiler.TakeTypeProfileResponse.class, timeout);
    }

}