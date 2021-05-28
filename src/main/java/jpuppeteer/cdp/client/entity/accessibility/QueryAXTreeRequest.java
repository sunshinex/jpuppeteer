package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class QueryAXTreeRequest {

    /**
    * Identifier of the node for the root to query.
    */
    public final Integer nodeId;

    /**
    * Identifier of the backend node for the root to query.
    */
    public final Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper for the root to query.
    */
    public final String objectId;

    /**
    * Find nodes with this computed name.
    */
    public final String accessibleName;

    /**
    * Find nodes with this computed role.
    */
    public final String role;

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