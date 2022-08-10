package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when `Element`'s inline style is modified via a CSS property modification.
*/
public class InlineStyleInvalidatedEvent {

    /**
    * Ids of the nodes for which the inline styles have been invalidated.
    */
    private java.util.List<Integer> nodeIds;

    public void setNodeIds (java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public java.util.List<Integer> getNodeIds() {
        return this.nodeIds;
    }

    public InlineStyleInvalidatedEvent(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public InlineStyleInvalidatedEvent() {
    }

}