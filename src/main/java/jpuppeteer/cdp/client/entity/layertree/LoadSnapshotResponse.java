package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LoadSnapshotResponse {

    /**
    * The id of the snapshot.
    */
    private String snapshotId;

    public void setSnapshotId (String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public LoadSnapshotResponse(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public LoadSnapshotResponse() {
    }

}