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
    public io.netty.util.concurrent.Future addInspectedHeapObject(jpuppeteer.cdp.client.entity.heapprofiler.AddInspectedHeapObjectRequest request) {
        return connection.send("HeapProfiler.addInspectedHeapObject", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future collectGarbage() {
        return connection.send("HeapProfiler.collectGarbage", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future disable() {
        return connection.send("HeapProfiler.disable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future enable() {
        return connection.send("HeapProfiler.enable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdResponse> getHeapObjectId(jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdRequest request) {
        return connection.send("HeapProfiler.getHeapObjectId", request, jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdResponse> getObjectByHeapObjectId(jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdRequest request) {
        return connection.send("HeapProfiler.getObjectByHeapObjectId", request, jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.heapprofiler.GetSamplingProfileResponse> getSamplingProfile() {
        return connection.send("HeapProfiler.getSamplingProfile", null, jpuppeteer.cdp.client.entity.heapprofiler.GetSamplingProfileResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future startSampling(jpuppeteer.cdp.client.entity.heapprofiler.StartSamplingRequest request) {
        return connection.send("HeapProfiler.startSampling", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future startTrackingHeapObjects(jpuppeteer.cdp.client.entity.heapprofiler.StartTrackingHeapObjectsRequest request) {
        return connection.send("HeapProfiler.startTrackingHeapObjects", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.heapprofiler.StopSamplingResponse> stopSampling() {
        return connection.send("HeapProfiler.stopSampling", null, jpuppeteer.cdp.client.entity.heapprofiler.StopSamplingResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future stopTrackingHeapObjects(jpuppeteer.cdp.client.entity.heapprofiler.StopTrackingHeapObjectsRequest request) {
        return connection.send("HeapProfiler.stopTrackingHeapObjects", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future takeHeapSnapshot(jpuppeteer.cdp.client.entity.heapprofiler.TakeHeapSnapshotRequest request) {
        return connection.send("HeapProfiler.takeHeapSnapshot", request);
    }

}