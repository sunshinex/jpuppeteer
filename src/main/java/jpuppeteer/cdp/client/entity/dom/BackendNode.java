package jpuppeteer.cdp.client.entity.dom;

/**
* Backend node with a friendly name.
*/
public class BackendNode {

    /**
    * `Node`'s nodeType.
    */
    public final Integer nodeType;

    /**
    * `Node`'s nodeName.
    */
    public final String nodeName;

    /**
    */
    public final Integer backendNodeId;

    public BackendNode(Integer nodeType, String nodeName, Integer backendNodeId) {
        this.nodeType = nodeType;
        this.nodeName = nodeName;
        this.backendNodeId = backendNodeId;
    }

}