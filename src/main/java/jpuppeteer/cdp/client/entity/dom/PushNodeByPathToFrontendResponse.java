package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PushNodeByPathToFrontendResponse {

    /**
    * Id of the node for given path.
    */
    public final Integer nodeId;

    public PushNodeByPathToFrontendResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

}