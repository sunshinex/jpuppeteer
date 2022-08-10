package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetDocumentResponse {

    /**
    * Resulting node.
    */
    private jpuppeteer.cdp.client.entity.dom.Node root;

    public void setRoot (jpuppeteer.cdp.client.entity.dom.Node root) {
        this.root = root;
    }

    public jpuppeteer.cdp.client.entity.dom.Node getRoot() {
        return this.root;
    }

    public GetDocumentResponse(jpuppeteer.cdp.client.entity.dom.Node root) {
        this.root = root;
    }

    public GetDocumentResponse() {
    }

}