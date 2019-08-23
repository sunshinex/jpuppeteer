package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public void addInspectedHeapObject(jpuppeteer.cdp.cdp.entity.heapprofiler.AddInspectedHeapObjectRequest request, int timeout) throws Exception {
        session.send("HeapProfiler.addInspectedHeapObject", request, timeout);
    }


    /**
    * experimental
    */
    public void collectGarbage(int timeout) throws Exception {
        session.send("HeapProfiler.collectGarbage", null, timeout);
    }


    /**
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("HeapProfiler.disable", null, timeout);
    }


    /**
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("HeapProfiler.enable", null, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.heapprofiler.GetHeapObjectIdResponse getHeapObjectId(jpuppeteer.cdp.cdp.entity.heapprofiler.GetHeapObjectIdRequest request, int timeout) throws Exception {
        return session.send("HeapProfiler.getHeapObjectId", request, jpuppeteer.cdp.cdp.entity.heapprofiler.GetHeapObjectIdResponse.class, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.heapprofiler.GetObjectByHeapObjectIdResponse getObjectByHeapObjectId(jpuppeteer.cdp.cdp.entity.heapprofiler.GetObjectByHeapObjectIdRequest request, int timeout) throws Exception {
        return session.send("HeapProfiler.getObjectByHeapObjectId", request, jpuppeteer.cdp.cdp.entity.heapprofiler.GetObjectByHeapObjectIdResponse.class, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.heapprofiler.GetSamplingProfileResponse getSamplingProfile(int timeout) throws Exception {
        return session.send("HeapProfiler.getSamplingProfile", null, jpuppeteer.cdp.cdp.entity.heapprofiler.GetSamplingProfileResponse.class, timeout);
    }


    /**
    * experimental
    */
    public void startSampling(jpuppeteer.cdp.cdp.entity.heapprofiler.StartSamplingRequest request, int timeout) throws Exception {
        session.send("HeapProfiler.startSampling", request, timeout);
    }


    /**
    * experimental
    */
    public void startTrackingHeapObjects(jpuppeteer.cdp.cdp.entity.heapprofiler.StartTrackingHeapObjectsRequest request, int timeout) throws Exception {
        session.send("HeapProfiler.startTrackingHeapObjects", request, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.heapprofiler.StopSamplingResponse stopSampling(int timeout) throws Exception {
        return session.send("HeapProfiler.stopSampling", null, jpuppeteer.cdp.cdp.entity.heapprofiler.StopSamplingResponse.class, timeout);
    }


    /**
    * experimental
    */
    public void stopTrackingHeapObjects(jpuppeteer.cdp.cdp.entity.heapprofiler.StopTrackingHeapObjectsRequest request, int timeout) throws Exception {
        session.send("HeapProfiler.stopTrackingHeapObjects", request, timeout);
    }


    /**
    * experimental
    */
    public void takeHeapSnapshot(jpuppeteer.cdp.cdp.entity.heapprofiler.TakeHeapSnapshotRequest request, int timeout) throws Exception {
        session.send("HeapProfiler.takeHeapSnapshot", request, timeout);
    }

}