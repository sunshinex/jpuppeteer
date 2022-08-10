package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class SnapshotCommandLogRequest {

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

    public SnapshotCommandLogRequest(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public SnapshotCommandLogRequest() {
    }

}