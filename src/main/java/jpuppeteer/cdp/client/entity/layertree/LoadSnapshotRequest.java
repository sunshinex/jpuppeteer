package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class LoadSnapshotRequest {

    /**
    * An array of tiles composing the snapshot.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.layertree.PictureTile> tiles;

    public void setTiles (java.util.List<jpuppeteer.cdp.client.entity.layertree.PictureTile> tiles) {
        this.tiles = tiles;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.layertree.PictureTile> getTiles() {
        return this.tiles;
    }

    public LoadSnapshotRequest(java.util.List<jpuppeteer.cdp.client.entity.layertree.PictureTile> tiles) {
        this.tiles = tiles;
    }

    public LoadSnapshotRequest() {
    }

}