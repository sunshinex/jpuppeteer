package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when `Element`'s attribute is removed.
*/
public class AttributeRemovedEvent {

    /**
    * Id of the node that has changed.
    */
    public final Integer nodeId;

    /**
    * A ttribute name.
    */
    public final String name;

    public AttributeRemovedEvent(Integer nodeId, String name) {
        this.nodeId = nodeId;
        this.name = name;
    }

}