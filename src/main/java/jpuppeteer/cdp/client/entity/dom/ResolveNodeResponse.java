package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class ResolveNodeResponse {

    /**
    * JavaScript object wrapper for given node.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject object;

    public ResolveNodeResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject object) {
        this.object = object;
    }

}