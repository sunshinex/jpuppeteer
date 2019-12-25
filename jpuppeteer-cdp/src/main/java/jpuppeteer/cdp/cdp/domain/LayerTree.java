package jpuppeteer.cdp.cdp.domain;

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
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.layertree.CompositingReasonsResponse compositingReasons(jpuppeteer.cdp.cdp.entity.layertree.CompositingReasonsRequest request, int timeout) throws Exception {
        return session.send("LayerTree.compositingReasons", request, jpuppeteer.cdp.cdp.entity.layertree.CompositingReasonsResponse.class, timeout);
    }


    /**
    * Disables compositing tree inspection.
    * experimental
    */
    public void disable(int timeout) throws Exception {
        session.send("LayerTree.disable", null, timeout);
    }


    /**
    * Enables compositing tree inspection.
    * experimental
    */
    public void enable(int timeout) throws Exception {
        session.send("LayerTree.enable", null, timeout);
    }


    /**
    * Returns the snapshot identifier.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.layertree.LoadSnapshotResponse loadSnapshot(jpuppeteer.cdp.cdp.entity.layertree.LoadSnapshotRequest request, int timeout) throws Exception {
        return session.send("LayerTree.loadSnapshot", request, jpuppeteer.cdp.cdp.entity.layertree.LoadSnapshotResponse.class, timeout);
    }


    /**
    * Returns the layer snapshot identifier.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.layertree.MakeSnapshotResponse makeSnapshot(jpuppeteer.cdp.cdp.entity.layertree.MakeSnapshotRequest request, int timeout) throws Exception {
        return session.send("LayerTree.makeSnapshot", request, jpuppeteer.cdp.cdp.entity.layertree.MakeSnapshotResponse.class, timeout);
    }


    /**
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.layertree.ProfileSnapshotResponse profileSnapshot(jpuppeteer.cdp.cdp.entity.layertree.ProfileSnapshotRequest request, int timeout) throws Exception {
        return session.send("LayerTree.profileSnapshot", request, jpuppeteer.cdp.cdp.entity.layertree.ProfileSnapshotResponse.class, timeout);
    }


    /**
    * Releases layer snapshot captured by the back-end.
    * experimental
    */
    public void releaseSnapshot(jpuppeteer.cdp.cdp.entity.layertree.ReleaseSnapshotRequest request, int timeout) throws Exception {
        session.send("LayerTree.releaseSnapshot", request, timeout);
    }


    /**
    * Replays the layer snapshot and returns the resulting bitmap.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.layertree.ReplaySnapshotResponse replaySnapshot(jpuppeteer.cdp.cdp.entity.layertree.ReplaySnapshotRequest request, int timeout) throws Exception {
        return session.send("LayerTree.replaySnapshot", request, jpuppeteer.cdp.cdp.entity.layertree.ReplaySnapshotResponse.class, timeout);
    }


    /**
    * Replays the layer snapshot and returns canvas log.
    * experimental
    */
    public jpuppeteer.cdp.cdp.entity.layertree.SnapshotCommandLogResponse snapshotCommandLog(jpuppeteer.cdp.cdp.entity.layertree.SnapshotCommandLogRequest request, int timeout) throws Exception {
        return session.send("LayerTree.snapshotCommandLog", request, jpuppeteer.cdp.cdp.entity.layertree.SnapshotCommandLogResponse.class, timeout);
    }

}