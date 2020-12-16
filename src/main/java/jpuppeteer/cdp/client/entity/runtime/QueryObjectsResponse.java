package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class QueryObjectsResponse {

    /**
    * Array with objects.
    */
    public final RemoteObject objects;

    public QueryObjectsResponse(RemoteObject objects) {
        this.objects = objects;
    }

}