package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class ScrollSnapHighlightConfig {

    /**
    * A descriptor for the highlight appearance of scroll snap containers.
    */
    public final jpuppeteer.cdp.client.entity.overlay.ScrollSnapContainerHighlightConfig scrollSnapContainerHighlightConfig;

    /**
    * Identifier of the node to highlight.
    */
    public final Integer nodeId;

    public ScrollSnapHighlightConfig(jpuppeteer.cdp.client.entity.overlay.ScrollSnapContainerHighlightConfig scrollSnapContainerHighlightConfig, Integer nodeId) {
        this.scrollSnapContainerHighlightConfig = scrollSnapContainerHighlightConfig;
        this.nodeId = nodeId;
    }

}