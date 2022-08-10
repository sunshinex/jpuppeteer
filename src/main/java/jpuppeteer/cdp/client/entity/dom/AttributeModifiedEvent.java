package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when `Element`'s attribute is modified.
*/
public class AttributeModifiedEvent {

    /**
    * Id of the node that has changed.
    */
    private Integer nodeId;

    /**
    * Attribute name.
    */
    private String name;

    /**
    * Attribute value.
    */
    private String value;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public AttributeModifiedEvent(Integer nodeId, String name, String value) {
        this.nodeId = nodeId;
        this.name = name;
        this.value = value;
    }

    public AttributeModifiedEvent() {
    }

}