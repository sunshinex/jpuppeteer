package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RequestNodeRequest {

    /**
    * JavaScript object id to convert into node.
    */
    private String objectId;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public RequestNodeRequest(String objectId) {
        this.objectId = objectId;
    }

    public RequestNodeRequest() {
    }

}