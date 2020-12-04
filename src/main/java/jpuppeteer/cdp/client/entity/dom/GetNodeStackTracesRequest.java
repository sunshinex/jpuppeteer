package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetNodeStackTracesRequest {

    /**
    * Id of the node to get stack traces for.
    */
    public final Integer nodeId;

    public GetNodeStackTracesRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}