package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetHighlightObjectForTestRequest {

    /**
    * Id of the node to get highlight object for.
    */
    public final Integer nodeId;

    /**
    * Whether to include distance info.
    */
    public final Boolean includeDistance;

    /**
    * Whether to include style info.
    */
    public final Boolean includeStyle;

    public GetHighlightObjectForTestRequest(Integer nodeId, Boolean includeDistance, Boolean includeStyle) {
        this.nodeId = nodeId;
        this.includeDistance = includeDistance;
        this.includeStyle = includeStyle;
    }

    public GetHighlightObjectForTestRequest(Integer nodeId) {
        this.nodeId = nodeId;
        this.includeDistance = null;
        this.includeStyle = null;
    }

}