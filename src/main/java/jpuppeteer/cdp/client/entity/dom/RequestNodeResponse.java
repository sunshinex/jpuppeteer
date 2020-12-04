package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RequestNodeResponse {

    /**
    * Node id for given object.
    */
    public final Integer nodeId;

    public RequestNodeResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

}