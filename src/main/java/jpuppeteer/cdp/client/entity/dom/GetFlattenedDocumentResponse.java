package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetFlattenedDocumentResponse {

    /**
    * Resulting node.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.dom.Node> nodes;

    public void setNodes (java.util.List<jpuppeteer.cdp.client.entity.dom.Node> nodes) {
        this.nodes = nodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.dom.Node> getNodes() {
        return this.nodes;
    }

    public GetFlattenedDocumentResponse(java.util.List<jpuppeteer.cdp.client.entity.dom.Node> nodes) {
        this.nodes = nodes;
    }

    public GetFlattenedDocumentResponse() {
    }

}