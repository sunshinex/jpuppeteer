package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class GetSourceOrderHighlightObjectForTestResponse {

    /**
    * Source order highlight data for the node id provided.
    */
    private java.util.Map<String, Object> highlight;

    public void setHighlight (java.util.Map<String, Object> highlight) {
        this.highlight = highlight;
    }

    public java.util.Map<String, Object> getHighlight() {
        return this.highlight;
    }

    public GetSourceOrderHighlightObjectForTestResponse(java.util.Map<String, Object> highlight) {
        this.highlight = highlight;
    }

    public GetSourceOrderHighlightObjectForTestResponse() {
    }

}