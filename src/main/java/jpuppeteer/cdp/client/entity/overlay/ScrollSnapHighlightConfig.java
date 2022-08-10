package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class ScrollSnapHighlightConfig {

    /**
    * A descriptor for the highlight appearance of scroll snap containers.
    */
    private jpuppeteer.cdp.client.entity.overlay.ScrollSnapContainerHighlightConfig scrollSnapContainerHighlightConfig;

    /**
    * Identifier of the node to highlight.
    */
    private Integer nodeId;

    public void setScrollSnapContainerHighlightConfig (jpuppeteer.cdp.client.entity.overlay.ScrollSnapContainerHighlightConfig scrollSnapContainerHighlightConfig) {
        this.scrollSnapContainerHighlightConfig = scrollSnapContainerHighlightConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.ScrollSnapContainerHighlightConfig getScrollSnapContainerHighlightConfig() {
        return this.scrollSnapContainerHighlightConfig;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public ScrollSnapHighlightConfig(jpuppeteer.cdp.client.entity.overlay.ScrollSnapContainerHighlightConfig scrollSnapContainerHighlightConfig, Integer nodeId) {
        this.scrollSnapContainerHighlightConfig = scrollSnapContainerHighlightConfig;
        this.nodeId = nodeId;
    }

    public ScrollSnapHighlightConfig() {
    }

}