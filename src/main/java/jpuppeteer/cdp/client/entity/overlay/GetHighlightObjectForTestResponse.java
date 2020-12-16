package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetHighlightObjectForTestResponse {

    /**
    * Highlight data for the node.
    */
    public final java.util.Map<String, Object> highlight;

    public GetHighlightObjectForTestResponse(java.util.Map<String, Object> highlight) {
        this.highlight = highlight;
    }

}