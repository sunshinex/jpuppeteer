package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class GetSnapshotRequest {

    /**
    * Whitelist of computed styles to return.
    */
    private java.util.List<String> computedStyleWhitelist;

    /**
    * Whether or not to retrieve details of DOM listeners (default false).
    */
    private Boolean includeEventListeners;

    /**
    * Whether to determine and include the paint order index of LayoutTreeNodes (default false).
    */
    private Boolean includePaintOrder;

    /**
    * Whether to include UA shadow tree in the snapshot (default false).
    */
    private Boolean includeUserAgentShadowTree;

    public void setComputedStyleWhitelist (java.util.List<String> computedStyleWhitelist) {
        this.computedStyleWhitelist = computedStyleWhitelist;
    }

    public java.util.List<String> getComputedStyleWhitelist() {
        return this.computedStyleWhitelist;
    }

    public void setIncludeEventListeners (Boolean includeEventListeners) {
        this.includeEventListeners = includeEventListeners;
    }

    public Boolean getIncludeEventListeners() {
        return this.includeEventListeners;
    }

    public void setIncludePaintOrder (Boolean includePaintOrder) {
        this.includePaintOrder = includePaintOrder;
    }

    public Boolean getIncludePaintOrder() {
        return this.includePaintOrder;
    }

    public void setIncludeUserAgentShadowTree (Boolean includeUserAgentShadowTree) {
        this.includeUserAgentShadowTree = includeUserAgentShadowTree;
    }

    public Boolean getIncludeUserAgentShadowTree() {
        return this.includeUserAgentShadowTree;
    }

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

    public GetSnapshotRequest() {
    }

}