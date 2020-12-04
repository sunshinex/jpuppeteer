package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetHeapObjectIdRequest {

    /**
    * Identifier of the object to get heap object id for.
    */
    public final String objectId;

    public GetHeapObjectIdRequest(String objectId) {
        this.objectId = objectId;
    }

}