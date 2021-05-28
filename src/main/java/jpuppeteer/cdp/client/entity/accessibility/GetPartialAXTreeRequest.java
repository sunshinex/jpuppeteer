package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class GetPartialAXTreeRequest {

    /**
    * Identifier of the node to get the partial accessibility tree for.
    */
    public final Integer nodeId;

    /**
    * Identifier of the backend node to get the partial accessibility tree for.
    */
    public final Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper to get the partial accessibility tree for.
    */
    public final String objectId;

    /**
    * Whether to fetch this nodes ancestors, siblings and children. Defaults to true.
    */
    public final Boolean fetchRelatives;

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