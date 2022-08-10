package jpuppeteer.cdp.client.entity.applicationcache;

/**
* Frame identifier - manifest URL pair.
* experimental
*/
public class FrameWithManifest {

    /**
    * Frame identifier.
    */
    private String frameId;

    /**
    * Manifest URL.
    */
    private String manifestURL;

    /**
    * Application cache status.
    */
    private Integer status;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setManifestURL (String manifestURL) {
        this.manifestURL = manifestURL;
    }

    public String getManifestURL() {
        return this.manifestURL;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public FrameWithManifest(String frameId, String manifestURL, Integer status) {
        this.frameId = frameId;
        this.manifestURL = manifestURL;
        this.status = status;
    }

    public FrameWithManifest() {
    }

}