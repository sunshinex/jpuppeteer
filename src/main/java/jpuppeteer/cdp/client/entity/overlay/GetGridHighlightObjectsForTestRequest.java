package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetGridHighlightObjectsForTestRequest {

    /**
    * Ids of the node to get highlight object for.
    */
    public final java.util.List<Integer> nodeIds;

    public GetGridHighlightObjectsForTestRequest(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

}