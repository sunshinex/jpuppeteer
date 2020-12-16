package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class CopyToResponse {

    /**
    * Id of the node clone.
    */
    public final Integer nodeId;

    public CopyToResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

}