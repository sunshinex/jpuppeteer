package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class QuerySelectorRequest {

    /**
    * Id of the node to query upon.
    */
    private Integer nodeId;

    /**
    * Selector string.
    */
    private String selector;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setSelector (String selector) {
        this.selector = selector;
    }

    public String getSelector() {
        return this.selector;
    }

    public QuerySelectorRequest(Integer nodeId, String selector) {
        this.nodeId = nodeId;
        this.selector = selector;
    }

    public QuerySelectorRequest() {
    }

}