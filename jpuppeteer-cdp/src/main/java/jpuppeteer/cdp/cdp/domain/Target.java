package jpuppeteer.cdp.cdp.domain;

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
    public void activateTarget(jpuppeteer.cdp.cdp.entity.target.ActivateTargetRequest request, int timeout) throws Exception {
        connection.send("Target.activateTarget", request, timeout);
    }


    /**
    * Attaches to the target with given id.
    */
    public jpuppeteer.cdp.cdp.entity.target.AttachToTargetResponse attachToTarget(jpuppeteer.cdp.cdp.entity.target.AttachToTargetRequest request, int timeout) throws Exception {
        return connection.send("Target.attachToTarget", request, jpuppeteer.cdp.cdp.entity.target.AttachToTargetResponse.class, timeout);
    }


    /**
    * Attaches to the browser target, only uses flat sessionId mode.
    */
    public jpuppeteer.cdp.cdp.entity.target.AttachToBrowserTargetResponse attachToBrowserTarget(int timeout) throws Exception {
        return connection.send("Target.attachToBrowserTarget", null, jpuppeteer.cdp.cdp.entity.target.AttachToBrowserTargetResponse.class, timeout);
    }


    /**
    * Closes the target. If the target is a page that gets closed too.
    */
    public jpuppeteer.cdp.cdp.entity.target.CloseTargetResponse closeTarget(jpuppeteer.cdp.cdp.entity.target.CloseTargetRequest request, int timeout) throws Exception {
        return connection.send("Target.closeTarget", request, jpuppeteer.cdp.cdp.entity.target.CloseTargetResponse.class, timeout);
    }


    /**
    * Inject object to the target's main frame that provides a communication channel with browser target.  Injected object will be available as `window[bindingName]`.  The object has the follwing API: - `binding.send(json)` - a method to send messages over the remote debugging protocol - `binding.onmessage = json => handleMessage(json)` - a callback that will be called for the protocol notifications and command responses.
    */
    public void exposeDevToolsProtocol(jpuppeteer.cdp.cdp.entity.target.ExposeDevToolsProtocolRequest request, int timeout) throws Exception {
        connection.send("Target.exposeDevToolsProtocol", request, timeout);
    }


    /**
    * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than one.
    */
    public jpuppeteer.cdp.cdp.entity.target.CreateBrowserContextResponse createBrowserContext(int timeout) throws Exception {
        return connection.send("Target.createBrowserContext", null, jpuppeteer.cdp.cdp.entity.target.CreateBrowserContextResponse.class, timeout);
    }


    /**
    * Returns all browser contexts created with `Target.createBrowserContext` method.
    */
    public jpuppeteer.cdp.cdp.entity.target.GetBrowserContextsResponse getBrowserContexts(int timeout) throws Exception {
        return connection.send("Target.getBrowserContexts", null, jpuppeteer.cdp.cdp.entity.target.GetBrowserContextsResponse.class, timeout);
    }


    /**
    * Creates a new page.
    */
    public jpuppeteer.cdp.cdp.entity.target.CreateTargetResponse createTarget(jpuppeteer.cdp.cdp.entity.target.CreateTargetRequest request, int timeout) throws Exception {
        return connection.send("Target.createTarget", request, jpuppeteer.cdp.cdp.entity.target.CreateTargetResponse.class, timeout);
    }


    /**
    * Detaches session with given id.
    */
    public void detachFromTarget(jpuppeteer.cdp.cdp.entity.target.DetachFromTargetRequest request, int timeout) throws Exception {
        connection.send("Target.detachFromTarget", request, timeout);
    }


    /**
    * Deletes a BrowserContext. All the belonging pages will be closed without calling their beforeunload hooks.
    */
    public void disposeBrowserContext(jpuppeteer.cdp.cdp.entity.target.DisposeBrowserContextRequest request, int timeout) throws Exception {
        connection.send("Target.disposeBrowserContext", request, timeout);
    }


    /**
    * Returns information about a target.
    */
    public jpuppeteer.cdp.cdp.entity.target.GetTargetInfoResponse getTargetInfo(jpuppeteer.cdp.cdp.entity.target.GetTargetInfoRequest request, int timeout) throws Exception {
        return connection.send("Target.getTargetInfo", request, jpuppeteer.cdp.cdp.entity.target.GetTargetInfoResponse.class, timeout);
    }


    /**
    * Retrieves a list of available targets.
    */
    public jpuppeteer.cdp.cdp.entity.target.GetTargetsResponse getTargets(int timeout) throws Exception {
        return connection.send("Target.getTargets", null, jpuppeteer.cdp.cdp.entity.target.GetTargetsResponse.class, timeout);
    }


    /**
    * Sends protocol message over session with given id.
    */
    public void sendMessageToTarget(jpuppeteer.cdp.cdp.entity.target.SendMessageToTargetRequest request, int timeout) throws Exception {
        connection.send("Target.sendMessageToTarget", request, timeout);
    }


    /**
    * Controls whether to automatically attach to new targets which are considered to be related to this one. When turned on, attaches to all existing related targets as well. When turned off, automatically detaches from all currently attached targets.
    */
    public void setAutoAttach(jpuppeteer.cdp.cdp.entity.target.SetAutoAttachRequest request, int timeout) throws Exception {
        connection.send("Target.setAutoAttach", request, timeout);
    }


    /**
    * Controls whether to discover available targets and notify via `targetCreated/targetInfoChanged/targetDestroyed` events.
    */
    public void setDiscoverTargets(jpuppeteer.cdp.cdp.entity.target.SetDiscoverTargetsRequest request, int timeout) throws Exception {
        connection.send("Target.setDiscoverTargets", request, timeout);
    }


    /**
    * Enables target discovery for the specified locations, when `setDiscoverTargets` was set to `true`.
    */
    public void setRemoteLocations(jpuppeteer.cdp.cdp.entity.target.SetRemoteLocationsRequest request, int timeout) throws Exception {
        connection.send("Target.setRemoteLocations", request, timeout);
    }

}