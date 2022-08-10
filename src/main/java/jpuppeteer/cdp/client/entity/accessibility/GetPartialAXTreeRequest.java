package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class GetPartialAXTreeRequest {

    /**
    * Identifier of the node to get the partial accessibility tree for.
    */
    private Integer nodeId;

    /**
    * Identifier of the backend node to get the partial accessibility tree for.
    */
    private Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper to get the partial accessibility tree for.
    */
    private String objectId;

    /**
    * Whether to fetch this nodes ancestors, siblings and children. Defaults to true.
    */
    private Boolean fetchRelatives;

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

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setFetchRelatives (Boolean fetchRelatives) {
        this.fetchRelatives = fetchRelatives;
    }

    public Boolean getFetchRelatives() {
        return this.fetchRelatives;
    }

    public GetPartialAXTreeRequest(Integer nodeId, Integer backendNodeId, String objectId, Boolean fetchRelatives) {
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectId = objectId;
        this.fetchRelatives = fetchRelatives;
    }

    public GetPartialAXTreeRequest() {
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectId = null;
        this.fetchRelatives = null;
    }

}