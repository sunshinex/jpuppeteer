package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ReleaseSnapshotRequest {

    /**
    * The id of the layer snapshot.
    */
    public final String snapshotId;

    public ReleaseSnapshotRequest(String snapshotId) {
        this.snapshotId = snapshotId;
    }

}