package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetDocumentResponse {

    /**
    * Resulting node.
    */
    public final jpuppeteer.cdp.client.entity.dom.Node root;

    public GetDocumentResponse(jpuppeteer.cdp.client.entity.dom.Node root) {
        this.root = root;
    }

}