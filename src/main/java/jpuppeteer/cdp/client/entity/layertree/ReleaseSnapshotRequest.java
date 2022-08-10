package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ReleaseSnapshotRequest {

    /**
    * The id of the layer snapshot.
    */
    private String snapshotId;

    public void setSnapshotId (String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public ReleaseSnapshotRequest(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public ReleaseSnapshotRequest() {
    }

}