package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetHeapObjectIdRequest {

    /**
    * Identifier of the object to get heap object id for.
    */
    private String objectId;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public GetHeapObjectIdRequest(String objectId) {
        this.objectId = objectId;
    }

    public GetHeapObjectIdRequest() {
    }

}