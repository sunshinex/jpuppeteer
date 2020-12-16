package jpuppeteer.cdp.client.domain;

/**
*/
public class Target {

    private jpuppeteer.cdp.CDPConnection connection;

    public Target(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Activates (focuses) the target.
    */
    public io.netty.util.concurrent.Future activateTarget(jpuppeteer.cdp.client.entity.target.ActivateTargetRequest request) {
        return connection.send("Target.activateTarget", request);
    }


    /**
    * Attaches to the target with given id.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.target.AttachToTargetResponse> attachToTarget(jpuppeteer.cdp.client.entity.target.AttachToTargetRequest request) {
        return connection.send("Target.attachToTarget", request, jpuppeteer.cdp.client.entity.target.AttachToTargetResponse.class);
    }


    /**
    * Attaches to the browser target, only uses flat sessionId mode.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.target.AttachToBrowserTargetResponse> attachToBrowserTarget() {
        return connection.send("Target.attachToBrowserTarget", null, jpuppeteer.cdp.client.entity.target.AttachToBrowserTargetResponse.class);
    }


    /**
    * Closes the target. If the target is a page that gets closed too.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.target.CloseTargetResponse> closeTarget(jpuppeteer.cdp.client.entity.target.CloseTargetRequest request) {
        return connection.send("Target.closeTarget", request, jpuppeteer.cdp.client.entity.target.CloseTargetResponse.class);
    }


    /**
    * Inject object to the target's main frame that provides a communication channel with browser target.  Injected object will be available as `window[bindingName]`.  The object has the follwing API: - `binding.send(json)` - a method to send messages over the remote debugging protocol - `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
    * experimental
    */
    public io.netty.util.concurrent.Future exposeDevToolsProtocol(jpuppeteer.cdp.client.entity.target.ExposeDevToolsProtocolRequest request) {
        return connection.send("Target.exposeDevToolsProtocol", request);
    }


    /**
    * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than one.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.target.CreateBrowserContextResponse> createBrowserContext() {
        return connection.send("Target.createBrowserContext", null, jpuppeteer.cdp.client.entity.target.CreateBrowserContextResponse.class);
    }


    /**
    * Returns all browser contexts created with `Target.createBrowserContext` method.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.target.GetBrowserContextsResponse> getBrowserContexts() {
        return connection.send("Target.getBrowserContexts", null, jpuppeteer.cdp.client.entity.target.GetBrowserContextsResponse.class);
    }


    /**
    * Creates a new page.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.target.CreateTargetResponse> createTarget(jpuppeteer.cdp.client.entity.target.CreateTargetRequest request) {
        return connection.send("Target.createTarget", request, jpuppeteer.cdp.client.entity.target.CreateTargetResponse.class);
    }


    /**
    * Detaches session with given id.
    */
    public io.netty.util.concurrent.Future detachFromTarget(jpuppeteer.cdp.client.entity.target.DetachFromTargetRequest request) {
        return connection.send("Target.detachFromTarget", request);
    }


    /**
    * Deletes a BrowserContext. All the belonging pages will be closed without calling their beforeunload hooks.
    * experimental
    */
    public io.netty.util.concurrent.Future disposeBrowserContext(jpuppeteer.cdp.client.entity.target.DisposeBrowserContextRequest request) {
        return connection.send("Target.disposeBrowserContext", request);
    }


    /**
    * Returns information about a target.
    * experimental
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.target.GetTargetInfoResponse> getTargetInfo(jpuppeteer.cdp.client.entity.target.GetTargetInfoRequest request) {
        return connection.send("Target.getTargetInfo", request, jpuppeteer.cdp.client.entity.target.GetTargetInfoResponse.class);
    }


    /**
    * Retrieves a list of available targets.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.target.GetTargetsResponse> getTargets() {
        return connection.send("Target.getTargets", null, jpuppeteer.cdp.client.entity.target.GetTargetsResponse.class);
    }


    /**
    * Sends protocol message over session with given id. Consider using flat mode instead; see commands attachToTarget, setAutoAttach, and crbug.com/991325.
    */
    @Deprecated
    public io.netty.util.concurrent.Future sendMessageToTarget(jpuppeteer.cdp.client.entity.target.SendMessageToTargetRequest request) {
        return connection.send("Target.sendMessageToTarget", request);
    }


    /**
    * Controls whether to automatically attach to new targets which are considered to be related to this one. When turned on, attaches to all existing related targets as well. When turned off, automatically detaches from all currently attached targets.
    * experimental
    */
    public io.netty.util.concurrent.Future setAutoAttach(jpuppeteer.cdp.client.entity.target.SetAutoAttachRequest request) {
        return connection.send("Target.setAutoAttach", request);
    }


    /**
    * Controls whether to discover available targets and notify via `targetCreated/targetInfoChanged/targetDestroyed` events.
    */
    public io.netty.util.concurrent.Future setDiscoverTargets(jpuppeteer.cdp.client.entity.target.SetDiscoverTargetsRequest request) {
        return connection.send("Target.setDiscoverTargets", request);
    }


    /**
    * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to `true`.
    * experimental
    */
    public io.netty.util.concurrent.Future setRemoteLocations(jpuppeteer.cdp.client.entity.target.SetRemoteLocationsRequest request) {
        return connection.send("Target.setRemoteLocations", request);
    }

}