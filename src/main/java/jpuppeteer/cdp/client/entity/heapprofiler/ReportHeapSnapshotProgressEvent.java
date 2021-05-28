package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class ReportHeapSnapshotProgressEvent {

    /**
    */
    public final Integer done;

    /**
    */
    public final Integer total;

    /**
    */
    public final Boolean finished;

    public ReportHeapSnapshotProgressEvent(Integer done, Integer total, Boolean finished) {
        this.done = done;
        this.total = total;
        this.finished = finished;
    }

    public ReportHeapSnapshotProgressEvent(Integer done, Integer total) {
        this.done = done;
        this.total = total;
        this.finished = null;
    }

}