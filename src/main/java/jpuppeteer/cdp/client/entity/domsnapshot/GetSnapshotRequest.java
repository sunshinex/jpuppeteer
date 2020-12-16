package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class GetSnapshotRequest {

    /**
    * Whitelist of computed styles to return.
    */
    public final java.util.List<String> computedStyleWhitelist;

    /**
    * Whether or not to retrieve details of DOM listeners (default false).
    */
    public final Boolean includeEventListeners;

    /**
    * Whether to determine and include the paint order index of LayoutTreeNodes (default false).
    */
    public final Boolean includePaintOrder;

    /**
    * Whether to include UA shadow tree in the snapshot (default false).
    */
    public final Boolean includeUserAgentShadowTree;

    public GetSnapshotRequest(java.util.List<String> computedStyleWhitelist, Boolean includeEventListeners, Boolean includePaintOrder, Boolean includeUserAgentShadowTree) {
        this.computedStyleWhitelist = computedStyleWhitelist;
        this.includeEventListeners = includeEventListeners;
        this.includePaintOrder = includePaintOrder;
        this.includeUserAgentShadowTree = includeUserAgentShadowTree;
    }

    public GetSnapshotRequest(java.util.List<String> computedStyleWhitelist) {
        this.computedStyleWhitelist = computedStyleWhitelist;
        this.includeEventListeners = null;
        this.includePaintOrder = null;
        this.includeUserAgentShadowTree = null;
    }

}