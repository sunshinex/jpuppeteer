package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetNodeValueRequest {

    /**
    * Id of the node to set value for.
    */
    private Integer nodeId;

    /**
    * New node's value.
    */
    private String value;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public SetNodeValueRequest(Integer nodeId, String value) {
        this.nodeId = nodeId;
        this.value = value;
    }

    public SetNodeValueRequest() {
    }

}