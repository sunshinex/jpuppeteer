package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class ReplaySnapshotResponse {

    /**
    * A data: URL for resulting image.
    */
    public final String dataURL;

    public ReplaySnapshotResponse(String dataURL) {
        this.dataURL = dataURL;
    }

}