package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RemoveAttributeRequest {

    /**
    * Id of the element to remove attribute from.
    */
    private Integer nodeId;

    /**
    * Name of the attribute to remove.
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

    public RemoveAttributeRequest(Integer nodeId, String name) {
        this.nodeId = nodeId;
        this.name = name;
    }

    public RemoveAttributeRequest() {
    }

}