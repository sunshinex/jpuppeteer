package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CollectClassNamesFromSubtreeRequest {

    /**
    * Id of the node to collect class names.
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public CollectClassNamesFromSubtreeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public CollectClassNamesFromSubtreeRequest() {
    }

}