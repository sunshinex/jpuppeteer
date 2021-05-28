package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class DescribeNodeRequest {

    /**
    * Identifier of the node.
    */
    public final Integer nodeId;

    /**
    * Identifier of the backend node.
    */
    public final Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper.
    */
    public final String objectId;

    /**
    * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
    */
    public final Integer depth;

    /**
    * Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
    */
    public final Boolean pierce;

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