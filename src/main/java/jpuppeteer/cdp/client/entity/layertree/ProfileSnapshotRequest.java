package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ProfileSnapshotRequest {

    /**
    * The id of the layer snapshot.
    */
    public final String snapshotId;

    /**
    * The maximum number of times to replay the snapshot (1, if not specified).
    */
    public final Integer minRepeatCount;

    /**
    * The minimum duration (in seconds) to replay the snapshot.
    */
    public final java.math.BigDecimal minDuration;

    /**
    * The clip rectangle to apply when replaying the snapshot.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect clipRect;

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

}