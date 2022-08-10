package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetGridHighlightObjectsForTestResponse {

    /**
    * Grid Highlight data for the node ids provided.
    */
    private java.util.Map<String, Object> highlights;

    public void setHighlights (java.util.Map<String, Object> highlights) {
        this.highlights = highlights;
    }

    public java.util.Map<String, Object> getHighlights() {
        return this.highlights;
    }

    public GetGridHighlightObjectsForTestResponse(java.util.Map<String, Object> highlights) {
        this.highlights = highlights;
    }

    public GetGridHighlightObjectsForTestResponse() {
    }

}