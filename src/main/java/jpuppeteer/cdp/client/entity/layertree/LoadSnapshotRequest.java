package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LoadSnapshotRequest {

    /**
    * An array of tiles composing the snapshot.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.layertree.PictureTile> tiles;

    public LoadSnapshotRequest(java.util.List<jpuppeteer.cdp.client.entity.layertree.PictureTile> tiles) {
        this.tiles = tiles;
    }

}