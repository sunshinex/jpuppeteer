package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PushNodeByPathToFrontendRequest {

    /**
    * Path to node in the proprietary format.
    */
    public final String path;

    public PushNodeByPathToFrontendRequest(String path) {
        this.path = path;
    }

}