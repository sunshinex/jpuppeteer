package jpuppeteer.cdp.client.entity.dom;

/**
* Backend node with a friendly name.
*/
public class BackendNode {

    /**
    * `Node`'s nodeType.
    */
    private Integer nodeType;

    /**
    * `Node`'s nodeName.
    */
    private String nodeName;

    /**
    */
    private Integer backendNodeId;

    public void setNodeType (Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Integer getNodeType() {
        return this.nodeType;
    }

    public void setNodeName (String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public BackendNode(Integer nodeType, String nodeName, Integer backendNodeId) {
        this.nodeType = nodeType;
        this.nodeName = nodeName;
        this.backendNodeId = backendNodeId;
    }

    public BackendNode() {
    }

}