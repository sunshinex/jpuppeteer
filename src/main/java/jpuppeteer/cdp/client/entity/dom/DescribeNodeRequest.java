package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class DescribeNodeRequest {

    /**
    * Identifier of the node.
    */
    private Integer nodeId;

    /**
    * Identifier of the backend node.
    */
    private Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper.
    */
    private String objectId;

    /**
    * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
    */
    private Integer depth;

    /**
    * Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
    */
    private Boolean pierce;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
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

    public DescribeNodeRequest(Integer nodeId, Integer backendNodeId, String objectId, Integer depth, Boolean pierce) {
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectId = objectId;
        this.depth = depth;
        this.pierce = pierce;
    }

    public DescribeNodeRequest() {
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectId = null;
        this.depth = null;
        this.pierce = null;
    }

}