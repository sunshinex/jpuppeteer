package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class QueryObjectsRequest {

    /**
    * Identifier of the prototype to return objects for.
    */
    private String prototypeObjectId;

    /**
    * Symbolic group name that can be used to release the results.
    */
    private String objectGroup;

    public void setPrototypeObjectId (String prototypeObjectId) {
        this.prototypeObjectId = prototypeObjectId;
    }

    public String getPrototypeObjectId() {
        return this.prototypeObjectId;
    }

    public void setObjectGroup (String objectGroup) {
        this.objectGroup = objectGroup;
    }

    public String getObjectGroup() {
        return this.objectGroup;
    }

    public QueryObjectsRequest(String prototypeObjectId, String objectGroup) {
        this.prototypeObjectId = prototypeObjectId;
        this.objectGroup = objectGroup;
    }

    public QueryObjectsRequest(String prototypeObjectId) {
        this.prototypeObjectId = prototypeObjectId;
        this.objectGroup = null;
    }

    public QueryObjectsRequest() {
    }

}