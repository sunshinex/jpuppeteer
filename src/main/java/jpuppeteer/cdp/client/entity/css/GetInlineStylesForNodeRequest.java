package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetInlineStylesForNodeRequest {

    /**
    */
    public final Integer nodeId;

    public GetInlineStylesForNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}