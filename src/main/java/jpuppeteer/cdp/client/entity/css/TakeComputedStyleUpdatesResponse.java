package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class TakeComputedStyleUpdatesResponse {

    /**
    * The list of node Ids that have their tracked computed styles updated
    */
    public final java.util.List<Integer> nodeIds;

    public TakeComputedStyleUpdatesResponse(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

}