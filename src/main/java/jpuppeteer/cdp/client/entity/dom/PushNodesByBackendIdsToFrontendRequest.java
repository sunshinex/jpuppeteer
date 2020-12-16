package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PushNodesByBackendIdsToFrontendRequest {

    /**
    * The array of backend node ids.
    */
    public final java.util.List<Integer> backendNodeIds;

    public PushNodesByBackendIdsToFrontendRequest(java.util.List<Integer> backendNodeIds) {
        this.backendNodeIds = backendNodeIds;
    }

}