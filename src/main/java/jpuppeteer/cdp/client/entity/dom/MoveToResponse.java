package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class MoveToResponse {

    /**
    * New id of the moved node.
    */
    public final Integer nodeId;

    public MoveToResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

}