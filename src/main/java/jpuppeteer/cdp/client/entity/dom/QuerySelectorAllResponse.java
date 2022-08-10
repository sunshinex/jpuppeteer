package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class QuerySelectorAllResponse {

    /**
    * Query selector result.
    */
    private java.util.List<Integer> nodeIds;

    public void setNodeIds (java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public java.util.List<Integer> getNodeIds() {
        return this.nodeIds;
    }

    public QuerySelectorAllResponse(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public QuerySelectorAllResponse() {
    }

}