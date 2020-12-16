package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetDocumentResponse {

    /**
    * Resulting node.
    */
    public final Node root;

    public GetDocumentResponse(Node root) {
        this.root = root;
    }

}