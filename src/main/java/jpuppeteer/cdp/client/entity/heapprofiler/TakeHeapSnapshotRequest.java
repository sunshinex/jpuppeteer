package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class TakeHeapSnapshotRequest {

    /**
    * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
    */
    public final Boolean reportProgress;

    /**
    * If true, a raw snapshot without artifical roots will be generated
    */
    public final Boolean treatGlobalObjectsAsRoots;

    public TakeHeapSnapshotRequest(Boolean reportProgress, Boolean treatGlobalObjectsAsRoots) {
        this.reportProgress = reportProgress;
        this.treatGlobalObjectsAsRoots = treatGlobalObjectsAsRoots;
    }

    public TakeHeapSnapshotRequest() {
        this.reportProgress = null;
        this.treatGlobalObjectsAsRoots = null;
    }

}