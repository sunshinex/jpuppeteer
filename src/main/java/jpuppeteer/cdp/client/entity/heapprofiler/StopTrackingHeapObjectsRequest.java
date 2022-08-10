package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class StopTrackingHeapObjectsRequest {

    /**
    * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken when the tracking is stopped.
    */
    private Boolean reportProgress;

    /**
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

    public StopTrackingHeapObjectsRequest(Boolean reportProgress, Boolean treatGlobalObjectsAsRoots) {
        this.reportProgress = reportProgress;
        this.treatGlobalObjectsAsRoots = treatGlobalObjectsAsRoots;
    }

    public StopTrackingHeapObjectsRequest() {
        this.reportProgress = null;
        this.treatGlobalObjectsAsRoots = null;
    }

}