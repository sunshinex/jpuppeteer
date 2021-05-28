package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CreateIsolatedWorldRequest {

    /**
    * Id of the frame in which the isolated world should be created.
    */
    public final String frameId;

    /**
    * An optional name which is reported in the Execution Context.
    */
    public final String worldName;

    /**
    * Whether or not universal access should be granted to the isolated world. This is a powerful option, use with caution.
    */
    public final Boolean grantUniveralAccess;

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

}