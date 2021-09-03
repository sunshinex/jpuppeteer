package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetSourceOrderHighlightObjectForTestRequest {

    /**
    * Id of the node to highlight.
    */
    public final Integer nodeId;

    public GetSourceOrderHighlightObjectForTestRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}