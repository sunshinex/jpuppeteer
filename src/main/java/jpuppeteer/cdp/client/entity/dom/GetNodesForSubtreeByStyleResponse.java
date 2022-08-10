package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodesForSubtreeByStyleResponse {

    /**
    * Resulting nodes.
    */
    private java.util.List<Integer> nodeIds;

    public void setNodeIds (java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public java.util.List<Integer> getNodeIds() {
        return this.nodeIds;
    }

    public GetNodesForSubtreeByStyleResponse(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public GetNodesForSubtreeByStyleResponse() {
    }

}