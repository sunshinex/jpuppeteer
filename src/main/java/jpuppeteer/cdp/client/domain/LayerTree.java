package jpuppeteer.cdp.client.domain;

/**
* experimental
*/
public class LayerTree {

    private jpuppeteer.cdp.CDPSession session;

    public LayerTree(jpuppeteer.cdp.CDPSession session) {
        this.session = session;
    }

    /**
    * Provides the reasons why the given layer was composited.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.layertree.CompositingReasonsResponse> compositingReasons(jpuppeteer.cdp.client.entity.layertree.CompositingReasonsRequest request) {
        return session.send("LayerTree.compositingReasons", request, jpuppeteer.cdp.client.entity.layertree.CompositingReasonsResponse.class);
    }


    /**
    * Disables compositing tree inspection.
    */
    public io.netty.util.concurrent.Future disable() {
        return session.send("LayerTree.disable", null);
    }


    /**
    * Enables compositing tree inspection.
    */
    public io.netty.util.concurrent.Future enable() {
        return session.send("LayerTree.enable", null);
    }


    /**
    * Returns the snapshot identifier.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.layertree.LoadSnapshotResponse> loadSnapshot(jpuppeteer.cdp.client.entity.layertree.LoadSnapshotRequest request) {
        return session.send("LayerTree.loadSnapshot", request, jpuppeteer.cdp.client.entity.layertree.LoadSnapshotResponse.class);
    }


    /**
    * Returns the layer snapshot identifier.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.layertree.MakeSnapshotResponse> makeSnapshot(jpuppeteer.cdp.client.entity.layertree.MakeSnapshotRequest request) {
        return session.send("LayerTree.makeSnapshot", request, jpuppeteer.cdp.client.entity.layertree.MakeSnapshotResponse.class);
    }


    /**
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.layertree.ProfileSnapshotResponse> profileSnapshot(jpuppeteer.cdp.client.entity.layertree.ProfileSnapshotRequest request) {
        return session.send("LayerTree.profileSnapshot", request, jpuppeteer.cdp.client.entity.layertree.ProfileSnapshotResponse.class);
    }


    /**
    * Releases layer snapshot captured by the back-end.
    */
    public io.netty.util.concurrent.Future releaseSnapshot(jpuppeteer.cdp.client.entity.layertree.ReleaseSnapshotRequest request) {
        return session.send("LayerTree.releaseSnapshot", request);
    }


    /**
    * Replays the layer snapshot and returns the resulting bitmap.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.layertree.ReplaySnapshotResponse> replaySnapshot(jpuppeteer.cdp.client.entity.layertree.ReplaySnapshotRequest request) {
        return session.send("LayerTree.replaySnapshot", request, jpuppeteer.cdp.client.entity.layertree.ReplaySnapshotResponse.class);
    }


    /**
    * Replays the layer snapshot and returns canvas log.
    */
    public io.netty.util.concurrent.Future<jpuppeteer.cdp.client.entity.layertree.SnapshotCommandLogResponse> snapshotCommandLog(jpuppeteer.cdp.client.entity.layertree.SnapshotCommandLogRequest request) {
        return session.send("LayerTree.snapshotCommandLog", request, jpuppeteer.cdp.client.entity.layertree.SnapshotCommandLogResponse.class);
    }

}