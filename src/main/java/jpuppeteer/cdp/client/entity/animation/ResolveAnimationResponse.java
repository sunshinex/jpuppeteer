package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class ResolveAnimationResponse {

    /**
    * Corresponding remote object.
    */
    public final jpuppeteer.cdp.client.entity.runtime.RemoteObject remoteObject;

    public ResolveAnimationResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject remoteObject) {
        this.remoteObject = remoteObject;
    }

}