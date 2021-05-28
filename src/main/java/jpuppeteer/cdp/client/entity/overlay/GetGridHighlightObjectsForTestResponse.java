package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetGridHighlightObjectsForTestResponse {

    /**
    * Grid Highlight data for the node ids provided.
    */
    public final java.util.Map<String, Object> highlights;

    public GetGridHighlightObjectsForTestResponse(java.util.Map<String, Object> highlights) {
        this.highlights = highlights;
    }

}