package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RemoveNodeRequest {

    /**
    * Id of the node to remove.
    */
    public final Integer nodeId;

    public RemoveNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}