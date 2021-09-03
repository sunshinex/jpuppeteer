package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class FlexNodeHighlightConfig {

    /**
    * A descriptor for the highlight appearance of flex containers.
    */
    public final jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig flexContainerHighlightConfig;

    /**
    * Identifier of the node to highlight.
    */
    public final Integer nodeId;

    public FlexNodeHighlightConfig(jpuppeteer.cdp.client.entity.overlay.FlexContainerHighlightConfig flexContainerHighlightConfig, Integer nodeId) {
        this.flexContainerHighlightConfig = flexContainerHighlightConfig;
        this.nodeId = nodeId;
    }

}