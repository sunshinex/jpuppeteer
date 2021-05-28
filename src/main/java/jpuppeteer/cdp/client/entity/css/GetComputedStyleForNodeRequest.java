package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetComputedStyleForNodeRequest {

    /**
    */
    public final Integer nodeId;

    public GetComputedStyleForNodeRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}