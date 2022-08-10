package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PushNodesByBackendIdsToFrontendResponse {

    /**
    * The array of ids of pushed nodes that correspond to the backend ids specified in backendNodeIds.
    */
    private java.util.List<Integer> nodeIds;

    public void setNodeIds (java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public java.util.List<Integer> getNodeIds() {
        return this.nodeIds;
    }

    public PushNodesByBackendIdsToFrontendResponse(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public PushNodesByBackendIdsToFrontendResponse() {
    }

}