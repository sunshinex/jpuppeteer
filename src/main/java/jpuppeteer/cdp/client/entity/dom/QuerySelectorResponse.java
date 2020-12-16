package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class QuerySelectorResponse {

    /**
    * Query selector result.
    */
    public final Integer nodeId;

    public QuerySelectorResponse(Integer nodeId) {
        this.nodeId = nodeId;
    }

}