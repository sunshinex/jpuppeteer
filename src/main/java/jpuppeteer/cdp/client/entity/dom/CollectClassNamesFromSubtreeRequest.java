package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CollectClassNamesFromSubtreeRequest {

    /**
    * Id of the node to collect class names.
    */
    public final Integer nodeId;

    public CollectClassNamesFromSubtreeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}