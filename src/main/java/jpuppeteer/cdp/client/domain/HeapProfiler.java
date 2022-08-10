package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class HeapProfiler {

    private jpuppeteer.cdp.CDPConnection connection;

    public HeapProfiler(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
    */
    public jpuppeteer.util.XFuture<?> addInspectedHeapObject(jpuppeteer.cdp.client.entity.heapprofiler.AddInspectedHeapObjectRequest request) {
        return connection.send("HeapProfiler.addInspectedHeapObject", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> collectGarbage() {
        return connection.send("HeapProfiler.collectGarbage", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("HeapProfiler.disable", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("HeapProfiler.enable", null);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdResponse> getHeapObjectId(jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdRequest request) {
        return connection.send("HeapProfiler.getHeapObjectId", request, jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdResponse.class);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdResponse> getObjectByHeapObjectId(jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdRequest request) {
        return connection.send("HeapProfiler.getObjectByHeapObjectId", request, jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdResponse.class);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.heapprofiler.GetSamplingProfileResponse> getSamplingProfile() {
        return connection.send("HeapProfiler.getSamplingProfile", null, jpuppeteer.cdp.client.entity.heapprofiler.GetSamplingProfileResponse.class);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> startSampling(jpuppeteer.cdp.client.entity.heapprofiler.StartSamplingRequest request) {
        return connection.send("HeapProfiler.startSampling", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> startTrackingHeapObjects(jpuppeteer.cdp.client.entity.heapprofiler.StartTrackingHeapObjectsRequest request) {
        return connection.send("HeapProfiler.startTrackingHeapObjects", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.heapprofiler.StopSamplingResponse> stopSampling() {
        return connection.send("HeapProfiler.stopSampling", null, jpuppeteer.cdp.client.entity.heapprofiler.StopSamplingResponse.class);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> stopTrackingHeapObjects(jpuppeteer.cdp.client.entity.heapprofiler.StopTrackingHeapObjectsRequest request) {
        return connection.send("HeapProfiler.stopTrackingHeapObjects", request);
    }


    /**
    */
    public jpuppeteer.util.XFuture<?> takeHeapSnapshot(jpuppeteer.cdp.client.entity.heapprofiler.TakeHeapSnapshotRequest request) {
        return connection.send("HeapProfiler.takeHeapSnapshot", request);
    }

}