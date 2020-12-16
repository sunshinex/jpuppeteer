package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class MakeSnapshotResponse {

    /**
    * The id of the layer snapshot.
    */
    public final String snapshotId;

    public MakeSnapshotResponse(String snapshotId) {
        this.snapshotId = snapshotId;
    }

}