package jpuppeteer.cdp.client.entity.target;

/**
*/
public class AttachToTargetRequest {

    /**
    */
    private String targetId;

    /**
    * Enables "flat" access to the session via specifying sessionId attribute in the commands. We plan to make this the default, deprecate non-flattened mode, and eventually retire it. See crbug.com/991325.
    */
    private Boolean flatten;

    public void setTargetId (String targetId) {
        this.targetId = targetId;
    }

    public String getTargetId() {
        return this.targetId;
    }

    public void setFlatten (Boolean flatten) {
        this.flatten = flatten;
    }

    public Boolean getFlatten() {
        return this.flatten;
    }

    public AttachToTargetRequest(String targetId, Boolean flatten) {
        this.targetId = targetId;
        this.flatten = flatten;
    }

    public AttachToTargetRequest(String targetId) {
        this.targetId = targetId;
        this.flatten = null;
    }

    public AttachToTargetRequest() {
    }

}