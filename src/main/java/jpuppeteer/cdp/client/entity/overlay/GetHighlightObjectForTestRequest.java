package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetHighlightObjectForTestRequest {

    /**
    * Id of the node to get highlight object for.
    */
    private Integer nodeId;

    /**
    * Whether to include distance info.
    */
    private Boolean includeDistance;

    /**
    * Whether to include style info.
    */
    private Boolean includeStyle;

    /**
    * The color format to get config with (default: hex).
    */
    private jpuppeteer.cdp.client.constant.overlay.ColorFormat colorFormat;

    /**
    * Whether to show accessibility info (default: true).
    */
    private Boolean showAccessibilityInfo;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setIncludeDistance (Boolean includeDistance) {
        this.includeDistance = includeDistance;
    }

    public Boolean getIncludeDistance() {
        return this.includeDistance;
    }

    public void setIncludeStyle (Boolean includeStyle) {
        this.includeStyle = includeStyle;
    }

    public Boolean getIncludeStyle() {
        return this.includeStyle;
    }

    public void setColorFormat (jpuppeteer.cdp.client.constant.overlay.ColorFormat colorFormat) {
        this.colorFormat = colorFormat;
    }

    public jpuppeteer.cdp.client.constant.overlay.ColorFormat getColorFormat() {
        return this.colorFormat;
    }

    public void setShowAccessibilityInfo (Boolean showAccessibilityInfo) {
        this.showAccessibilityInfo = showAccessibilityInfo;
    }

    public Boolean getShowAccessibilityInfo() {
        return this.showAccessibilityInfo;
    }

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

    public GetHighlightObjectForTestRequest() {
    }

}