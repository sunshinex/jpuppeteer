package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetSourceOrderHighlightObjectForTestResponse {

    /**
    * Source order highlight data for the node id provided.
    */
    public final java.util.Map<String, Object> highlight;

    public GetSourceOrderHighlightObjectForTestResponse(java.util.Map<String, Object> highlight) {
        this.highlight = highlight;
    }

}