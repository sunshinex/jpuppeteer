package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class ReleaseObjectGroupRequest {

    /**
    * Symbolic object group name.
    */
    private String objectGroup;

    public void setObjectGroup (String objectGroup) {
        this.objectGroup = objectGroup;
    }

    public String getObjectGroup() {
        return this.objectGroup;
    }

    public ReleaseObjectGroupRequest(String objectGroup) {
        this.objectGroup = objectGroup;
    }

    public ReleaseObjectGroupRequest() {
    }

}