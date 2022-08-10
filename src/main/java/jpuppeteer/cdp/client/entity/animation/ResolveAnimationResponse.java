package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class ResolveAnimationResponse {

    /**
    * Corresponding remote object.
    */
    private jpuppeteer.cdp.client.entity.runtime.RemoteObject remoteObject;

    public void setRemoteObject (jpuppeteer.cdp.client.entity.runtime.RemoteObject remoteObject) {
        this.remoteObject = remoteObject;
    }

    public jpuppeteer.cdp.client.entity.runtime.RemoteObject getRemoteObject() {
        return this.remoteObject;
    }

    public ResolveAnimationResponse(jpuppeteer.cdp.client.entity.runtime.RemoteObject remoteObject) {
        this.remoteObject = remoteObject;
    }

    public ResolveAnimationResponse() {
    }

}