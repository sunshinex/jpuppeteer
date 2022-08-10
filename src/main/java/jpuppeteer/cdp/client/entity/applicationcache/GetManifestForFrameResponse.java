package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetManifestForFrameResponse {

    /**
    * Manifest URL for document in the given frame.
    */
    private String manifestURL;

    public void setManifestURL (String manifestURL) {
        this.manifestURL = manifestURL;
    }

    public String getManifestURL() {
        return this.manifestURL;
    }

    public GetManifestForFrameResponse(String manifestURL) {
        this.manifestURL = manifestURL;
    }

    public GetManifestForFrameResponse() {
    }

}