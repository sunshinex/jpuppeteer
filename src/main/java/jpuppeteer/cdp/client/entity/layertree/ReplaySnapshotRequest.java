package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ReplaySnapshotRequest {

    /**
    * The id of the layer snapshot.
    */
    public final String snapshotId;

    /**
    * The first step to replay from (replay from the very start if not specified).
    */
    public final Integer fromStep;

    /**
    * The last step to replay to (replay till the end if not specified).
    */
    public final Integer toStep;

    /**
    * The scale to apply while replaying (defaults to 1).
    */
    public final java.math.BigDecimal scale;

    public ReplaySnapshotRequest(String snapshotId, Integer fromStep, Integer toStep, java.math.BigDecimal scale) {
        this.snapshotId = snapshotId;
        this.fromStep = fromStep;
        this.toStep = toStep;
        this.scale = scale;
    }

    public ReplaySnapshotRequest(String snapshotId) {
        this.snapshotId = snapshotId;
        this.fromStep = null;
        this.toStep = null;
        this.scale = null;
    }

}