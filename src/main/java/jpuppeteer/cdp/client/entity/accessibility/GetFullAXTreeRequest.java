package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class GetFullAXTreeRequest {

    /**
    * The maximum depth at which descendants of the root node should be retrieved. If omitted, the full tree is returned.
    */
    public final Integer max_depth;

    public GetFullAXTreeRequest(Integer max_depth) {
        this.max_depth = max_depth;
    }

    public GetFullAXTreeRequest() {
        this.max_depth = null;
    }

}