package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LoadSnapshotRequest {

    /**
    * An array of tiles composing the snapshot.
    */
    public final java.util.List<PictureTile> tiles;

    public LoadSnapshotRequest(java.util.List<PictureTile> tiles) {
        this.tiles = tiles;
    }

}