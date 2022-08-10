package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetFileInfoRequest {

    /**
    * JavaScript object id of the node wrapper.
    */
    private String objectId;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public GetFileInfoRequest(String objectId) {
        this.objectId = objectId;
    }

    public GetFileInfoRequest() {
    }

}