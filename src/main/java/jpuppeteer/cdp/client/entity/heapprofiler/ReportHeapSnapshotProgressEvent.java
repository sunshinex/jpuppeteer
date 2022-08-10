package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class ReportHeapSnapshotProgressEvent {

    /**
    */
    private Integer done;

    /**
    */
    private Integer total;

    /**
    */
    private Boolean finished;

    public void setDone (Integer done) {
        this.done = done;
    }

    public Integer getDone() {
        return this.done;
    }

    public void setTotal (Integer total) {
        this.total = total;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setFinished (Boolean finished) {
        this.finished = finished;
    }

    public Boolean getFinished() {
        return this.finished;
    }

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

    public ReportHeapSnapshotProgressEvent() {
    }

}