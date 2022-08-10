package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetSearchResultsResponse {

    /**
    * Ids of the search result nodes.
    */
    private java.util.List<Integer> nodeIds;

    public void setNodeIds (java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public java.util.List<Integer> getNodeIds() {
        return this.nodeIds;
    }

    public GetSearchResultsResponse(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public GetSearchResultsResponse() {
    }

}