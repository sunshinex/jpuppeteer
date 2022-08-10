package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class Tracing {

    private jpuppeteer.cdp.CDPConnection connection;

    public Tracing(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Stop trace events collection.
    */
    public jpuppeteer.util.XFuture<?> end() {
        return connection.send("Tracing.end", null);
    }


    /**
    * Gets supported tracing categories.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.tracing.GetCategoriesResponse> getCategories() {
        return connection.send("Tracing.getCategories", null, jpuppeteer.cdp.client.entity.tracing.GetCategoriesResponse.class);
    }


    /**
    * Record a clock sync marker in the trace.
    */
    public jpuppeteer.util.XFuture<?> recordClockSyncMarker(jpuppeteer.cdp.client.entity.tracing.RecordClockSyncMarkerRequest request) {
        return connection.send("Tracing.recordClockSyncMarker", request);
    }


    /**
    * Request a global memory dump.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.tracing.RequestMemoryDumpResponse> requestMemoryDump(jpuppeteer.cdp.client.entity.tracing.RequestMemoryDumpRequest request) {
        return connection.send("Tracing.requestMemoryDump", request, jpuppeteer.cdp.client.entity.tracing.RequestMemoryDumpResponse.class);
    }


    /**
    * Start trace events collection.
    */
    public jpuppeteer.util.XFuture<?> start(jpuppeteer.cdp.client.entity.tracing.StartRequest request) {
        return connection.send("Tracing.start", request);
    }

}