package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetGridHighlightObjectsForTestRequest {

    /**
    * Ids of the node to get highlight object for.
    */
    private java.util.List<Integer> nodeIds;

    public void setNodeIds (java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public java.util.List<Integer> getNodeIds() {
        return this.nodeIds;
    }

    public GetGridHighlightObjectsForTestRequest(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public GetGridHighlightObjectsForTestRequest() {
    }

}