package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class QueryObjectsResponse {

    /**
    * Array with objects.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject objects;

    public void setObjects (jpuppeteer.cdp.client.entity.runtime.RemoteObject objects) {
        this.objects = objects;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getObjects() {
        return this.objects;
    }

    public QueryObjectsResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject objects) {
        this.objects = objects;
    }

    public QueryObjectsResponse() {
    }

}