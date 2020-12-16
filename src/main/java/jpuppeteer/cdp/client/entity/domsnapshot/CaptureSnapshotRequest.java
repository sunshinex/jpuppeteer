package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class CaptureSnapshotRequest {

    /**
    * Whitelist of computed styles to return.
    */
    public final java.util.List<String> computedStyles;

    /**
    * Whether to include layout object paint orders into the snapshot.
    */
    public final Boolean includePaintOrder;

    /**
    * Whether to include DOM rectangles (offsetRects, clientRects, scrollRects) into the snapshot
    */
    public final Boolean includeDOMRects;

    public CaptureSnapshotRequest(java.util.List<String> computedStyles, Boolean includePaintOrder, Boolean includeDOMRects) {
        this.computedStyles = computedStyles;
        this.includePaintOrder = includePaintOrder;
        this.includeDOMRects = includeDOMRects;
    }

    public CaptureSnapshotRequest(java.util.List<String> computedStyles) {
        this.computedStyles = computedStyles;
        this.includePaintOrder = null;
        this.includeDOMRects = null;
    }

}