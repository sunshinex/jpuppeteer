package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when `Element`'s inline style is modified via a CSS property modification.
*/
public class InlineStyleInvalidatedEvent {

    /**
    * Ids of the nodes for which the inline styles have been invalidated.
    */
    public final java.util.List<Integer> nodeIds;

    public InlineStyleInvalidatedEvent(java.util.List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

}