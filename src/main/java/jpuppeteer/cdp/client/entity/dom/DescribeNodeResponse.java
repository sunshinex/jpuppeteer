package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class DescribeNodeResponse {

    /**
    * Node description.
    */
    private jpuppeteer.cdp.client.entity.dom.Node node;

    public void setNode (jpuppeteer.cdp.client.entity.dom.Node node) {
        this.node = node;
    }

    public jpuppeteer.cdp.client.entity.dom.Node getNode() {
        return this.node;
    }

    public DescribeNodeResponse(jpuppeteer.cdp.client.entity.dom.Node node) {
        this.node = node;
    }

    public DescribeNodeResponse() {
    }

}