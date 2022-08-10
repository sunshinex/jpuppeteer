package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CreateIsolatedWorldRequest {

    /**
    * Id of the frame in which the isolated world should be created.
    */
    private String frameId;

    /**
    * An optional name which is reported in the Execution Context.
    */
    private String worldName;

    /**
    * Whether or not universal access should be granted to the isolated world. This is a powerful option, use with caution.
    */
    private Boolean grantUniveralAccess;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setWorldName (String worldName) {
        this.worldName = worldName;
    }

    public String getWorldName() {
        return this.worldName;
    }

    public void setGrantUniveralAccess (Boolean grantUniveralAccess) {
        this.grantUniveralAccess = grantUniveralAccess;
    }

    public Boolean getGrantUniveralAccess() {
        return this.grantUniveralAccess;
    }

    public CreateIsolatedWorldRequest(String frameId, String worldName, Boolean grantUniveralAccess) {
        this.frameId = frameId;
        this.worldName = worldName;
        this.grantUniveralAccess = grantUniveralAccess;
    }

    public CreateIsolatedWorldRequest(String frameId) {
        this.frameId = frameId;
        this.worldName = null;
        this.grantUniveralAccess = null;
    }

    public CreateIsolatedWorldRequest() {
    }

}