package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class QuerySelectorAllResponse {

    /**
    * Query selector result.
    */
    public final java.util.List<Integer> nodeIds;

    public QuerySelectorAllResponse(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

}