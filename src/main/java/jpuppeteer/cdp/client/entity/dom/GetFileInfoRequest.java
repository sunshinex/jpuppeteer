package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetFileInfoRequest {

    /**
    * JavaScript object id of the node wrapper.
    */
    public final String objectId;

    public GetFileInfoRequest(String objectId) {
        this.objectId = objectId;
    }

}