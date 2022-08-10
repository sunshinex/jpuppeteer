package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RequestChildNodesRequest {

    /**
    * Id of the node to get children for.
    */
    private Integer nodeId;

    /**
    * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
    */
    private Integer depth;

    /**
    * Whether or not iframes and shadow roots should be traversed when returning the sub-tree (default is false).
    */
    private Boolean pierce;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setDepth (Integer depth) {
        this.depth = depth;
    }

    public Integer getDepth() {
        return this.depth;
    }

    public void setPierce (Boolean pierce) {
        this.pierce = pierce;
    }

    public Boolean getPierce() {
        return this.pierce;
    }

    public RequestChildNodesRequest(Integer nodeId, Integer depth, Boolean pierce) {
        this.nodeId = nodeId;
        this.depth = depth;
        this.pierce = pierce;
    }

    public RequestChildNodesRequest(Integer nodeId) {
        this.nodeId = nodeId;
        this.depth = null;
        this.pierce = null;
    }

    public RequestChildNodesRequest() {
    }

}