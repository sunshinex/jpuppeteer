package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetRelayoutBoundaryRequest {

    /**
    * Id of the node.
    */
    public final Integer nodeId;

    public GetRelayoutBoundaryRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}