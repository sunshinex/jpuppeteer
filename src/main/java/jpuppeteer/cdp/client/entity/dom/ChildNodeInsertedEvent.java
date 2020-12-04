package jpuppeteer.cdp.client.entity.dom;

/**
* Mirrors `DOMNodeInserted` event.
*/
public class ChildNodeInsertedEvent {

    /**
    * Id of the node that has changed.
    */
    public final Integer parentNodeId;

    /**
    * If of the previous siblint.
    */
    public final Integer previousNodeId;

    /**
    * Inserted node data.
    */
    public final jpuppeteer.cdp.client.entity.dom.Node node;

    public ChildNodeInsertedEvent(Integer parentNodeId, Integer previousNodeId, jpuppeteer.cdp.client.entity.dom.Node node) {
        this.parentNodeId = parentNodeId;
        this.previousNodeId = previousNodeId;
        this.node = node;
    }

}