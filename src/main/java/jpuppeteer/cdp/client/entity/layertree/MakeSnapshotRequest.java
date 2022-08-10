package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class MakeSnapshotRequest {

    /**
    * The id of the layer.
    */
    private String layerId;

    public void setLayerId (String layerId) {
        this.layerId = layerId;
    }

    public String getLayerId() {
        return this.layerId;
    }

    public MakeSnapshotRequest(String layerId) {
        this.layerId = layerId;
    }

    public MakeSnapshotRequest() {
    }

}