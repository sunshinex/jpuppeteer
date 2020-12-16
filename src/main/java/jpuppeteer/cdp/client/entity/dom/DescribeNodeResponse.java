package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class DescribeNodeResponse {

    /**
    * Node description.
    */
    public final Node node;

    public DescribeNodeResponse(Node node) {
        this.node = node;
    }

}