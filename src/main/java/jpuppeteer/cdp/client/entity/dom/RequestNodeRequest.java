package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class RequestNodeRequest {

    /**
    * JavaScript object id to convert into node.
    */
    public final String objectId;

    public RequestNodeRequest(String objectId) {
        this.objectId = objectId;
    }

}