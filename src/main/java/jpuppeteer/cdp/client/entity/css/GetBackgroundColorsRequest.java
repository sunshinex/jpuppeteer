package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class GetBackgroundColorsRequest {

    /**
    * Id of the node to get background colors for.
    */
    public final Integer nodeId;

    public GetBackgroundColorsRequest(Integer nodeId) {
        this.nodeId = nodeId;
    }

}