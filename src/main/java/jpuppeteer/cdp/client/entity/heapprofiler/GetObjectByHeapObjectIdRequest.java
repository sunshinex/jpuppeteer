package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetObjectByHeapObjectIdRequest {

    /**
    */
    private String objectId;

    /**
    * Symbolic group name that can be used to release multiple objects.
    */
    private String objectGroup;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectGroup (String objectGroup) {
        this.objectGroup = objectGroup;
    }

    public String getObjectGroup() {
        return this.objectGroup;
    }

    public GetObjectByHeapObjectIdRequest(String objectId, String objectGroup) {
        this.objectId = objectId;
        this.objectGroup = objectGroup;
    }

    public GetObjectByHeapObjectIdRequest(String objectId) {
        this.objectId = objectId;
        this.objectGroup = null;
    }

    public GetObjectByHeapObjectIdRequest() {
    }

}