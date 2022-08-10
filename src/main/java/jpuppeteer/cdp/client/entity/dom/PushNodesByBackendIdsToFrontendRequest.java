package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PushNodesByBackendIdsToFrontendRequest {

    /**
    * The array of backend node ids.
    */
    private java.util.List<Integer> backendNodeIds;

    public void setBackendNodeIds (java.util.List<Integer> backendNodeIds) {
        this.backendNodeIds = backendNodeIds;
    }

    public java.util.List<Integer> getBackendNodeIds() {
        return this.backendNodeIds;
    }

    public PushNodesByBackendIdsToFrontendRequest(java.util.List<Integer> backendNodeIds) {
        this.backendNodeIds = backendNodeIds;
    }

    public PushNodesByBackendIdsToFrontendRequest() {
    }

}