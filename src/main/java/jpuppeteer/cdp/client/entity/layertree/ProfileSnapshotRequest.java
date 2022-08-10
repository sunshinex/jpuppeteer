package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ProfileSnapshotRequest {

    /**
    * The id of the layer snapshot.
    */
    private String snapshotId;

    /**
    * The maximum number of times to replay the snapshot (1, if not specified).
    */
    private Integer minRepeatCount;

    /**
    * The minimum duration (in seconds) to replay the snapshot.
    */
    private java.math.BigDecimal minDuration;

    /**
    * The clip rectangle to apply when replaying the snapshot.
    */
    private jpuppeteer.cdp.client.entity.dom.Rect clipRect;

    public void setSnapshotId (String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public void setMinRepeatCount (Integer minRepeatCount) {
        this.minRepeatCount = minRepeatCount;
    }

    public Integer getMinRepeatCount() {
        return this.minRepeatCount;
    }

    public void setMinDuration (java.math.BigDecimal minDuration) {
        this.minDuration = minDuration;
    }

    public java.math.BigDecimal getMinDuration() {
        return this.minDuration;
    }

    public void setClipRect (jpuppeteer.cdp.client.entity.dom.Rect clipRect) {
        this.clipRect = clipRect;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getClipRect() {
        return this.clipRect;
    }

    public ProfileSnapshotRequest(String snapshotId, Integer minRepeatCount, java.math.BigDecimal minDuration, jpuppeteer.cdp.client.entity.dom.Rect clipRect) {
        this.snapshotId = snapshotId;
        this.minRepeatCount = minRepeatCount;
        this.minDuration = minDuration;
        this.clipRect = clipRect;
    }

    public ProfileSnapshotRequest(String snapshotId) {
        this.snapshotId = snapshotId;
        this.minRepeatCount = null;
        this.minDuration = null;
        this.clipRect = null;
    }

    public ProfileSnapshotRequest() {
    }

}