package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetAttributesRequest {

    /**
    * Id of the node to retrieve attibutes for.
    */
    public final Integer nodeId;

    public GetAttributesRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}