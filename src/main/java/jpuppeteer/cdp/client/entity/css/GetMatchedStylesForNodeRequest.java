package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetMatchedStylesForNodeRequest {

    /**
    */
    public final Integer nodeId;

    public GetMatchedStylesForNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}