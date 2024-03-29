package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class LayerTree {

    private jpuppeteer.cdp.CDPConnection connection;

    public LayerTree(jpuppeteer.cdp.CDPConnection connection) {
        this.connection = connection;
    }

    /**
    * Provides the reasons why the given layer was composited.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.layertree.CompositingReasonsResponse> compositingReasons(jpuppeteer.cdp.client.entity.layertree.CompositingReasonsRequest request) {
        return connection.send("LayerTree.compositingReasons", request, jpuppeteer.cdp.client.entity.layertree.CompositingReasonsResponse.class);
    }


    /**
    * Disables compositing tree inspection.
    */
    public jpuppeteer.util.XFuture<?> disable() {
        return connection.send("LayerTree.disable", null);
    }


    /**
    * Enables compositing tree inspection.
    */
    public jpuppeteer.util.XFuture<?> enable() {
        return connection.send("LayerTree.enable", null);
    }


    /**
    * Returns the snapshot identifier.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.layertree.LoadSnapshotResponse> loadSnapshot(jpuppeteer.cdp.client.entity.layertree.LoadSnapshotRequest request) {
        return connection.send("LayerTree.loadSnapshot", request, jpuppeteer.cdp.client.entity.layertree.LoadSnapshotResponse.class);
    }


    /**
    * Returns the layer snapshot identifier.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.layertree.MakeSnapshotResponse> makeSnapshot(jpuppeteer.cdp.client.entity.layertree.MakeSnapshotRequest request) {
        return connection.send("LayerTree.makeSnapshot", request, jpuppeteer.cdp.client.entity.layertree.MakeSnapshotResponse.class);
    }


    /**
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.layertree.ProfileSnapshotResponse> profileSnapshot(jpuppeteer.cdp.client.entity.layertree.ProfileSnapshotRequest request) {
        return connection.send("LayerTree.profileSnapshot", request, jpuppeteer.cdp.client.entity.layertree.ProfileSnapshotResponse.class);
    }


    /**
    * Releases layer snapshot captured by the back-end.
    */
    public jpuppeteer.util.XFuture<?> releaseSnapshot(jpuppeteer.cdp.client.entity.layertree.ReleaseSnapshotRequest request) {
        return connection.send("LayerTree.releaseSnapshot", request);
    }


    /**
    * Replays the layer snapshot and returns the resulting bitmap.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.layertree.ReplaySnapshotResponse> replaySnapshot(jpuppeteer.cdp.client.entity.layertree.ReplaySnapshotRequest request) {
        return connection.send("LayerTree.replaySnapshot", request, jpuppeteer.cdp.client.entity.layertree.ReplaySnapshotResponse.class);
    }


    /**
    * Replays the layer snapshot and returns canvas log.
    */
    public jpuppeteer.util.XFuture<jpuppeteer.cdp.client.entity.layertree.SnapshotCommandLogResponse> snapshotCommandLog(jpuppeteer.cdp.client.entity.layertree.SnapshotCommandLogRequest request) {
        return connection.send("LayerTree.snapshotCommandLog", request, jpuppeteer.cdp.client.entity.layertree.SnapshotCommandLogResponse.class);
    }

}