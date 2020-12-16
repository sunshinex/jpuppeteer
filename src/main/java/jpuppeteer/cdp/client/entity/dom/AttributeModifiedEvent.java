package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when `Element`'s attribute is modified.
*/
public class AttributeModifiedEvent {

    /**
    * Id of the node that has changed.
    */
    public final Integer nodeId;

    /**
    * Attribute name.
    */
    public final String name;

    /**
    * Attribute value.
    */
    public final String value;

    public AttributeModifiedEvent(Integer nodeId, String name, String value) {
        this.nodeId = nodeId;
        this.name = name;
        this.value = value;
    }

}