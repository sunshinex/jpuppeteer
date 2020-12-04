package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class ResolveNodeRequest {

    /**
    * Id of the node to resolve.
    */
    public final Integer nodeId;

    /**
    * Backend identifier of the node to resolve.
    */
    public final Integer backendNodeId;

    /**
    * Symbolic group name that can be used to release multiple objects.
    */
    public final String objectGroup;

    /**
    * Execution context in which to resolve the node.
    */
    public final Integer executionContextId;

    public ResolveNodeRequest(Integer nodeId, Integer backendNodeId, String objectGroup, Integer executionContextId) {
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectGroup = objectGroup;
        this.executionContextId = executionContextId;
    }

    public ResolveNodeRequest() {
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectGroup = null;
        this.executionContextId = null;
    }

}