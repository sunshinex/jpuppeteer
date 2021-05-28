package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetFlattenedDocumentRequest {

    /**
    * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
    */
    public final Integer depth;

    /**
    * Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
    */
    public final Boolean pierce;

    public GetFlattenedDocumentRequest(Integer depth, Boolean pierce) {
        this.depth = depth;
        this.pierce = pierce;
    }

    public GetFlattenedDocumentRequest() {
        this.depth = null;
        this.pierce = null;
    }

}