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

    /**
    * The color format to get config with (default: hex).
    */
    public final jpuppeteer.cdp.client.constant.overlay.ColorFormat colorFormat;

    /**
    * Whether to show accessibility info (default: true).
    */
    public final Boolean showAccessibilityInfo;

    public GetHighlightObjectForTestRequest(Integer nodeId, Boolean includeDistance, Boolean includeStyle, jpuppeteer.cdp.client.constant.overlay.ColorFormat colorFormat, Boolean showAccessibilityInfo) {
        this.nodeId = nodeId;
        this.includeDistance = includeDistance;
        this.includeStyle = includeStyle;
        this.colorFormat = colorFormat;
        this.showAccessibilityInfo = showAccessibilityInfo;
    }

    public GetHighlightObjectForTestRequest(Integer nodeId) {
        this.nodeId = nodeId;
        this.includeDistance = null;
        this.includeStyle = null;
        this.colorFormat = null;
        this.showAccessibilityInfo = null;
    }

}