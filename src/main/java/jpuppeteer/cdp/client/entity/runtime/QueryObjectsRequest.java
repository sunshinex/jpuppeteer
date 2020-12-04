package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class QueryObjectsRequest {

    /**
    * Identifier of the prototype to return objects for.
    */
    public final String prototypeObjectId;

    /**
    * Symbolic group name that can be used to release the results.
    */
    public final String objectGroup;

    public QueryObjectsRequest(String prototypeObjectId, String objectGroup) {
        this.prototypeObjectId = prototypeObjectId;
        this.objectGroup = objectGroup;
    }

    public QueryObjectsRequest(String prototypeObjectId) {
        this.prototypeObjectId = prototypeObjectId;
        this.objectGroup = null;
    }

}