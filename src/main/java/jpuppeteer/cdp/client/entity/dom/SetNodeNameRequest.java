package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetNodeNameRequest {

    /**
    * Id of the node to set name for.
    */
    private Integer nodeId;

    /**
    * New node's name.
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

    public SetNodeNameRequest(Integer nodeId, String name) {
        this.nodeId = nodeId;
        this.name = name;
    }

    public SetNodeNameRequest() {
    }

}