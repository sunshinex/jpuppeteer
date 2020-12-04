package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class QuerySelectorRequest {

    /**
    * Id of the node to query upon.
    */
    public final Integer nodeId;

    /**
    * Selector string.
    */
    public final String selector;

    public QuerySelectorRequest(Integer nodeId, String selector) {
        this.nodeId = nodeId;
        this.selector = selector;
    }

}