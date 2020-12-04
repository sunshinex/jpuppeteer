package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class GetManifestForFrameResponse {

    /**
    * Manifest URL for document in the given frame.
    */
    public final String manifestURL;

    public GetManifestForFrameResponse(String manifestURL) {
        this.manifestURL = manifestURL;
    }

}