package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class ResolveNodeResponse {

    /**
    * JavaScript object wrapper for given node.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject object;

    public void setObject (jpuppeteer.cdp.client.entity.runtime.RemoteObject object) {
        this.object = object;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getObject() {
        return this.object;
    }

    public ResolveNodeResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject object) {
        this.object = object;
    }

    public ResolveNodeResponse() {
    }

}