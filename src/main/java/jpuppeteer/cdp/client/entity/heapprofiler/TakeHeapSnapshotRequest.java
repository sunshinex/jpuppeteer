package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class TakeHeapSnapshotRequest {

    /**
    * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
    */
    private Boolean reportProgress;

    /**
    * If true, a raw snapshot without artifical roots will be generated
    */
    private Boolean treatGlobalObjectsAsRoots;

    public void setReportProgress (Boolean reportProgress) {
        this.reportProgress = reportProgress;
    }

    public Boolean getReportProgress() {
        return this.reportProgress;
    }

    public void setTreatGlobalObjectsAsRoots (Boolean treatGlobalObjectsAsRoots) {
        this.treatGlobalObjectsAsRoots = treatGlobalObjectsAsRoots;
    }

    public Boolean getTreatGlobalObjectsAsRoots() {
        return this.treatGlobalObjectsAsRoots;
    }

    public TakeHeapSnapshotRequest(Boolean reportProgress, Boolean treatGlobalObjectsAsRoots) {
        this.reportProgress = reportProgress;
        this.treatGlobalObjectsAsRoots = treatGlobalObjectsAsRoots;
    }

    public TakeHeapSnapshotRequest() {
        this.reportProgress = null;
        this.treatGlobalObjectsAsRoots = null;
    }

}