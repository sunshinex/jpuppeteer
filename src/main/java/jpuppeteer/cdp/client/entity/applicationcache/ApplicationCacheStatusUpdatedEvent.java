package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class ApplicationCacheStatusUpdatedEvent {

    /**
    * Identifier of the frame containing document whose application cache updated status.
    */
    private String frameId;

    /**
    * Manifest URL.
    */
    private String manifestURL;

    /**
    * Updated application cache status.
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

    public ApplicationCacheStatusUpdatedEvent(String frameId, String manifestURL, Integer status) {
        this.frameId = frameId;
        this.manifestURL = manifestURL;
        this.status = status;
    }

    public ApplicationCacheStatusUpdatedEvent() {
    }

}