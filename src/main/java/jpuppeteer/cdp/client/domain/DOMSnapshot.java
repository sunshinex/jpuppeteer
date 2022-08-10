package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class DOMSnapshot {

    private jpuppeteer.cdp.CDPConnection connection;

    public DOMSnapshot(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Disables DOM snapshot agent for the given page.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("DOMSnapshot.disable", null);
    }


    /**
    * Enables DOM snapshot agent for the given page.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("DOMSnapshot.enable", null);
    }


    /**
    * Returns a document snapshot, including the full DOM tree of the root node (including iframes, template contents, and imported documents) in a flattened array, as well as layout and white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is flattened.
    */
    @java.lang.Deprecated
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.domsnapshot.GetSnapshotResponse> getSnapshot(jpuppeteer.cdp.client.entity.domsnapshot.GetSnapshotRequest request) {
        return connection.send("DOMSnapshot.getSnapshot", request, jpuppeteer.cdp.client.entity.domsnapshot.GetSnapshotResponse.class);
    }


    /**
    * Returns a document snapshot, including the full DOM tree of the root node (including iframes, template contents, and imported documents) in a flattened array, as well as layout and white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is flattened.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.domsnapshot.CaptureSnapshotResponse> captureSnapshot(jpuppeteer.cdp.client.entity.domsnapshot.CaptureSnapshotRequest request) {
        return connection.send("DOMSnapshot.captureSnapshot", request, jpuppeteer.cdp.client.entity.domsnapshot.CaptureSnapshotResponse.class);
    }

}