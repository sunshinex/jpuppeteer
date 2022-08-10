package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class QuerySelectorResponse {

    /**
    * Query selector result.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public QuerySelectorResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public QuerySelectorResponse() {
    }

}