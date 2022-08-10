package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class GetEventListenersRequest {

    /**
    * Identifier of the object to return listeners for.
    */
    private String objectId;

    /**
    * The maximum depth at which Node children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
    */
    private Integer depth;

    /**
    * Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false). Reports listeners for all contexts if pierce is enabled.
    */
    private Boolean pierce;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setDepth (Integer depth) {
        this.depth = depth;
    }

    public Integer getDepth() {
        return this.depth;
    }

    public void setPierce (Boolean pierce) {
        this.pierce = pierce;
    }

    public Boolean getPierce() {
        return this.pierce;
    }

    public GetEventListenersRequest(String objectId, Integer depth, Boolean pierce) {
        this.objectId = objectId;
        this.depth = depth;
        this.pierce = pierce;
    }

    public GetEventListenersRequest(String objectId) {
        this.objectId = objectId;
        this.depth = null;
        this.pierce = null;
    }

    public GetEventListenersRequest() {
    }

}