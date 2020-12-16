package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class StopTrackingHeapObjectsRequest {

    /**
    * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken when the tracking is stopped.
    */
    public final Boolean reportProgress;

    /**
    */
    public final Boolean treatGlobalObjectsAsRoots;

    public StopTrackingHeapObjectsRequest(Boolean reportProgress, Boolean treatGlobalObjectsAsRoots) {
        this.reportProgress = reportProgress;
        this.treatGlobalObjectsAsRoots = treatGlobalObjectsAsRoots;
    }

    public StopTrackingHeapObjectsRequest() {
        this.reportProgress = null;
        this.treatGlobalObjectsAsRoots = null;
    }

}