package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class SnapshotCommandLogRequest {

    /**
    * The id of the layer snapshot.
    */
    public final String snapshotId;

    public SnapshotCommandLogRequest(String snapshotId) {
        this.snapshotId = snapshotId;
    }

}