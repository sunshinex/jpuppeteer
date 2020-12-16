package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetRelayoutBoundaryResponse {

    /**
    * Relayout boundary node id for the given node.
    */
    public final Integer nodeId;

    public GetRelayoutBoundaryResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

}