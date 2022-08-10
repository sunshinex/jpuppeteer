package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class ResolveNodeRequest {

    /**
    * Id of the node to resolve.
    */
    private Integer nodeId;

    /**
    * Backend identifier of the node to resolve.
    */
    private Integer backendNodeId;

    /**
    * Symbolic group name that can be used to release multiple objects.
    */
    private String objectGroup;

    /**
    * Execution context in which to resolve the node.
    */
    private Integer executionContextId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setObjectGroup (String objectGroup) {
        this.objectGroup = objectGroup;
    }

    public String getObjectGroup() {
        return this.objectGroup;
    }

    public void setExecutionContextId (Integer executionContextId) {
        this.executionContextId = executionContextId;
    }

    public Integer getExecutionContextId() {
        return this.executionContextId;
    }

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