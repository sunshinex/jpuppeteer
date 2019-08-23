package jpuppeteer.cdp.cdp.domain;

/**
* experimental
*/
public class Tracing {

    private jpuppeteer.cdp.CDPSession session;

    public Tracing(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Stop trace events collection.
    * experimental
    */
    public void end(int timeout) throws Exception {
        session.send("Tracing.end", null, timeout);
    }


    /**
    * Gets supported tracing categories.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.tracing.GetCategoriesResponse getCategories(int timeout) throws Exception {
        return session.send("Tracing.getCategories", null, jpuppeteer.cdp.cdp.entity.tracing.GetCategoriesResponse.class, timeout);
    }


    /**
    * Record a clock sync marker in the trace.
    * experimental
    */
    public void recordClockSyncMarker(jpuppeteer.cdp.cdp.entity.tracing.RecordClockSyncMarkerRequest request, int timeout) throws Exception {
        session.send("Tracing.recordClockSyncMarker", request, timeout);
    }


    /**
    * Request a global memory dump.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.tracing.RequestMemoryDumpResponse requestMemoryDump(int timeout) throws Exception {
        return session.send("Tracing.requestMemoryDump", null, jpuppeteer.cdp.cdp.entity.tracing.RequestMemoryDumpResponse.class, timeout);
    }


    /**
    * Start trace events collection.
    * experimental
    */
    public void start(jpuppeteer.cdp.cdp.entity.tracing.StartRequest request, int timeout) throws Exception {
        session.send("Tracing.start", request, timeout);
    }

}