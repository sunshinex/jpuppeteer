package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class TakeComputedStyleUpdatesResponse {

    /**
    * The list of node Ids that have their tracked computed styles updated
    */
    private java.util.List<Integer> nodeIds;

    public void setNodeIds (java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public java.util.List<Integer> getNodeIds() {
        return this.nodeIds;
    }

    public TakeComputedStyleUpdatesResponse(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public TakeComputedStyleUpdatesResponse() {
    }

}