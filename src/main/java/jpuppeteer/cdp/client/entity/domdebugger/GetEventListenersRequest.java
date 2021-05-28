package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class GetEventListenersRequest {

    /**
    * Identifier of the object to return listeners for.
    */
    public final String objectId;

    /**
    * The maximum depth at which Node children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
    */
    public final Integer depth;

    /**
    * Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false). Reports listeners for all contexts if pierce is enabled.
    */
    public final Boolean pierce;

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

}