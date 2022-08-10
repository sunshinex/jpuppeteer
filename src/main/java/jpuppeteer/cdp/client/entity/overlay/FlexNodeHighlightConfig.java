package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class FlexNodeHighlightConfig {

    /**
    * A descriptor for the highlight appearance of flex containers.
    */
    private jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig flexContainerHighlightConfig;

    /**
    * Identifier of the node to highlight.
    */
    private Integer nodeId;

    public void setFlexContainerHighlightConfig (jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig flexContainerHighlightConfig) {
        this.flexContainerHighlightConfig = flexContainerHighlightConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig getFlexContainerHighlightConfig() {
        return this.flexContainerHighlightConfig;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public FlexNodeHighlightConfig(jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig flexContainerHighlightConfig, Integer nodeId) {
        this.flexContainerHighlightConfig = flexContainerHighlightConfig;
        this.nodeId = nodeId;
    }

    public FlexNodeHighlightConfig() {
    }

}