package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ReplaySnapshotRequest {

    /**
    * The id of the layer snapshot.
    */
    private String snapshotId;

    /**
    * The first step to replay from (replay from the very start if not specified).
    */
    private Integer fromStep;

    /**
    * The last step to replay to (replay till the end if not specified).
    */
    private Integer toStep;

    /**
    * The scale to apply while replaying (defaults to 1).
    */
    private java.math.BigDecimal scale;

    public void setSnapshotId (String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public void setFromStep (Integer fromStep) {
        this.fromStep = fromStep;
    }

    public Integer getFromStep() {
        return this.fromStep;
    }

    public void setToStep (Integer toStep) {
        this.toStep = toStep;
    }

    public Integer getToStep() {
        return this.toStep;
    }

    public void setScale (java.math.BigDecimal scale) {
        this.scale = scale;
    }

    public java.math.BigDecimal getScale() {
        return this.scale;
    }

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

    public ReplaySnapshotRequest() {
    }

}