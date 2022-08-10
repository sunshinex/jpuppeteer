package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when `Element`'s attribute is removed.
*/
public class AttributeRemovedEvent {

    /**
    * Id of the node that has changed.
    */
    private Integer nodeId;

    /**
    * A ttribute name.
    */
    private String name;

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

    public AttributeRemovedEvent(Integer nodeId, String name) {
        this.nodeId = nodeId;
        this.name = name;
    }

    public AttributeRemovedEvent() {
    }

}