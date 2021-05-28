package jpuppeteer.cdp.client.entity.applicationcache;

/**
* Frame identifier - manifest URL pair.
* experimental
*/
public class FrameWithManifest {

    /**
    * Frame identifier.
    */
    public final String frameId;

    /**
    * Manifest URL.
    */
    public final String manifestURL;

    /**
    * Application cache status.
    */
    public final Integer status;

    public FrameWithManifest(String frameId, String manifestURL, Integer status) {
        this.frameId = frameId;
        this.manifestURL = manifestURL;
        this.status = status;
    }

}