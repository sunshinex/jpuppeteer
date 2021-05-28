package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class DOMSnapshot {

    private jpuppeteer.cdp.CDPSession session;

    public DOMSnapshot(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Disables DOM snapshot agent for the given page.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("DOMSnapshot.disable", null);
    }


    /**
    * Enables DOM snapshot agent for the given page.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("DOMSnapshot.enable", null);
    }


    /**
    * Returns a document snapshot, including the full DOM tree of the root node (including iframes, template contents, and imported documents) in a flattened array, as well as layout and white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is flattened.
    */
    @java.lang.Deprecated
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.domsnapshot.GetSnapshotResponse> getSnapshot(jpuppeteer.cdp.client.entity.domsnapshot.GetSnapshotRequest request) {
        return session.send("DOMSnapshot.getSnapshot", request, jpuppeteer.cdp.client.entity.domsnapshot.GetSnapshotResponse.class);
    }


    /**
    * Returns a document snapshot, including the full DOM tree of the root node (including iframes, template contents, and imported documents) in a flattened array, as well as layout and white-listed computed style information for the nodes. Shadow DOM in the returned DOM tree is flattened.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.domsnapshot.CaptureSnapshotResponse> captureSnapshot(jpuppeteer.cdp.client.entity.domsnapshot.CaptureSnapshotRequest request) {
        return session.send("DOMSnapshot.captureSnapshot", request, jpuppeteer.cdp.client.entity.domsnapshot.CaptureSnapshotResponse.class);
    }

}