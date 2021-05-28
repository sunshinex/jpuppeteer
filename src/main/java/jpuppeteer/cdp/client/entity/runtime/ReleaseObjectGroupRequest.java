package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class ReleaseObjectGroupRequest {

    /**
    * Symbolic object group name.
    */
    public final String objectGroup;

    public ReleaseObjectGroupRequest(String objectGroup) {
        this.objectGroup = objectGroup;
    }

}