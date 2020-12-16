package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RequestChildNodesRequest {

    /**
    * Id of the node to get children for.
    */
    public final Integer nodeId;

    /**
    * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
    */
    public final Integer depth;

    /**
    * Whether or not iframes and shadow roots should be traversed when returning the sub-tree (default is false).
    */
    public final Boolean pierce;

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

}