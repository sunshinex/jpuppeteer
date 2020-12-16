package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class HeapProfiler {

    private jpuppeteer.cdp.CDPSession session;

    public HeapProfiler(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
    */
    public io.netty.util.concurrent.Future addInspectedHeapObject(jpuppeteer.cdp.client.entity.heapprofiler.AddInspectedHeapObjectRequest request) {
        return session.send("HeapProfiler.addInspectedHeapObject", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future collectGarbage() {
        return session.send("HeapProfiler.collectGarbage", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("HeapProfiler.disable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("HeapProfiler.enable", null);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdResponse> getHeapObjectId(jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdRequest request) {
        return session.send("HeapProfiler.getHeapObjectId", request, jpuppeteer.cdp.client.entity.heapprofiler.GetHeapObjectIdResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdResponse> getObjectByHeapObjectId(jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdRequest request) {
        return session.send("HeapProfiler.getObjectByHeapObjectId", request, jpuppeteer.cdp.client.entity.heapprofiler.GetObjectByHeapObjectIdResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.heapprofiler.GetSamplingProfileResponse> getSamplingProfile() {
        return session.send("HeapProfiler.getSamplingProfile", null, jpuppeteer.cdp.client.entity.heapprofiler.GetSamplingProfileResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future startSampling(jpuppeteer.cdp.client.entity.heapprofiler.StartSamplingRequest request) {
        return session.send("HeapProfiler.startSampling", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future startTrackingHeapObjects(jpuppeteer.cdp.client.entity.heapprofiler.StartTrackingHeapObjectsRequest request) {
        return session.send("HeapProfiler.startTrackingHeapObjects", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.heapprofiler.StopSamplingResponse> stopSampling() {
        return session.send("HeapProfiler.stopSampling", null, jpuppeteer.cdp.client.entity.heapprofiler.StopSamplingResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future stopTrackingHeapObjects(jpuppeteer.cdp.client.entity.heapprofiler.StopTrackingHeapObjectsRequest request) {
        return session.send("HeapProfiler.stopTrackingHeapObjects", request);
    }


    /**
    */
    public io.netty.util.concurrent.Future takeHeapSnapshot(jpuppeteer.cdp.client.entity.heapprofiler.TakeHeapSnapshotRequest request) {
        return session.send("HeapProfiler.takeHeapSnapshot", request);
    }

}