package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PushNodeByPathToFrontendRequest {

    /**
    * Path to node in the proprietary format.
    */
    private String path;

    public void setPath (String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public PushNodeByPathToFrontendRequest(String path) {
        this.path = path;
    }

    public PushNodeByPathToFrontendRequest() {
    }

}