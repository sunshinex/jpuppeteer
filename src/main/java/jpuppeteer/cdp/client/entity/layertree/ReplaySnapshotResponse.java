package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ReplaySnapshotResponse {

    /**
    * A data: URL for resulting image.
    */
    private String dataURL;

    public void setDataURL (String dataURL) {
        this.dataURL = dataURL;
    }

    public String getDataURL() {
        return this.dataURL;
    }

    public ReplaySnapshotResponse(String dataURL) {
        this.dataURL = dataURL;
    }

    public ReplaySnapshotResponse() {
    }

}