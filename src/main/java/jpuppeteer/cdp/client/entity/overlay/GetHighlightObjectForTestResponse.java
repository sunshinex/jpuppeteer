package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetHighlightObjectForTestResponse {

    /**
    * Highlight data for the node.
    */
    private java.util.Map<String, Object> highlight;

    public void setHighlight (java.util.Map<String, Object> highlight) {
        this.highlight = highlight;
    }

    public java.util.Map<String, Object> getHighlight() {
        return this.highlight;
    }

    public GetHighlightObjectForTestResponse(java.util.Map<String, Object> highlight) {
        this.highlight = highlight;
    }

    public GetHighlightObjectForTestResponse() {
    }

}