package jpuppeteer.cdp.client.domain;

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
    */
    public io.netty.util.concurrent.Future end() {
        return session.send("Tracing.end", null);
    }


    /**
    * Gets supported tracing categories.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.tracing.GetCategoriesResponse> getCategories() {
        return session.send("Tracing.getCategories", null, jpuppeteer.cdp.client.entity.tracing.GetCategoriesResponse.class);
    }


    /**
    * Record a clock sync marker in the trace.
    */
    public io.netty.util.concurrent.Future recordClockSyncMarker(jpuppeteer.cdp.client.entity.tracing.RecordClockSyncMarkerRequest request) {
        return session.send("Tracing.recordClockSyncMarker", request);
    }


    /**
    * Request a global memory dump.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.tracing.RequestMemoryDumpResponse> requestMemoryDump(jpuppeteer.cdp.client.entity.tracing.RequestMemoryDumpRequest request) {
        return session.send("Tracing.requestMemoryDump", request, jpuppeteer.cdp.client.entity.tracing.RequestMemoryDumpResponse.class);
    }


    /**
    * Start trace events collection.
    */
    public io.netty.util.concurrent.Future start(jpuppeteer.cdp.client.entity.tracing.StartRequest request) {
        return session.send("Tracing.start", request);
    }

}