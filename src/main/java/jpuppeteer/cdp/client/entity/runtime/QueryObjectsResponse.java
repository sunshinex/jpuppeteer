package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class QueryObjectsResponse {

    /**
    * Array with objects.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject objects;

    public QueryObjectsResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject objects) {
        this.objects = objects;
    }

}