package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LoadSnapshotResponse {

    /**
    * The id of the snapshot.
    */
    public final String snapshotId;

    public LoadSnapshotResponse(String snapshotId) {
        this.snapshotId = snapshotId;
    }

}