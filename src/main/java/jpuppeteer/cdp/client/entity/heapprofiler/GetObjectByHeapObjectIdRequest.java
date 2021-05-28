package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetObjectByHeapObjectIdRequest {

    /**
    */
    public final String objectId;

    /**
    * Symbolic group name that can be used to release multiple objects.
    */
    public final String objectGroup;

    public GetObjectByHeapObjectIdRequest(String objectId, String objectGroup) {
        this.objectId = objectId;
        this.objectGroup = objectGroup;
    }

    public GetObjectByHeapObjectIdRequest(String objectId) {
        this.objectId = objectId;
        this.objectGroup = null;
    }

}