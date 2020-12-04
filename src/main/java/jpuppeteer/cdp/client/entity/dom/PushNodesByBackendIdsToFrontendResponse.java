package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PushNodesByBackendIdsToFrontendResponse {

    /**
    * The array of ids of pushed nodes that correspond to the backend ids specified in backendNodeIds.
    */
    public final java.util.List<Integer> nodeIds;

    public PushNodesByBackendIdsToFrontendResponse(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

}