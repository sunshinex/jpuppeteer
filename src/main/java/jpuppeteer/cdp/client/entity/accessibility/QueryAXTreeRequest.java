package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class QueryAXTreeRequest {

    /**
    * Identifier of the node for the root to query.
    */
    private Integer nodeId;

    /**
    * Identifier of the backend node for the root to query.
    */
    private Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper for the root to query.
    */
    private String objectId;

    /**
    * Find nodes with this computed name.
    */
    private String accessibleName;

    /**
    * Find nodes with this computed role.
    */
    private String role;

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

    public void setAccessibleName (String accessibleName) {
        this.accessibleName = accessibleName;
    }

    public String getAccessibleName() {
        return this.accessibleName;
    }

    public void setRole (String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public QueryAXTreeRequest(Integer nodeId, Integer backendNodeId, String objectId, String accessibleName, String role) {
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectId = objectId;
        this.accessibleName = accessibleName;
        this.role = role;
    }

    public QueryAXTreeRequest() {
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectId = null;
        this.accessibleName = null;
        this.role = null;
    }

}