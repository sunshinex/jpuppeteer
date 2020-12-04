package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class MakeSnapshotRequest {

    /**
    * The id of the layer.
    */
    public final String layerId;

    public MakeSnapshotRequest(String layerId) {
        this.layerId = layerId;
    }

}