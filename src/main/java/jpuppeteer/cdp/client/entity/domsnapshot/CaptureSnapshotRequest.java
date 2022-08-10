package jpuppeteer.cdp.client.entity.domsnapshot;

/**
* experimental
*/
public class CaptureSnapshotRequest {

    /**
    * Whitelist of computed styles to return.
    */
    private java.util.List<String> computedStyles;

    /**
    * Whether to include layout object paint orders into the snapshot.
    */
    private Boolean includePaintOrder;

    /**
    * Whether to include DOM rectangles (offsetRects, clientRects, scrollRects) into the snapshot
    */
    private Boolean includeDOMRects;

    /**
    * Whether to include blended background colors in the snapshot (default: false). Blended background color is achieved by blending background colors of all elements that overlap with the current element.
    */
    private Boolean includeBlendedBackgroundColors;

    /**
    * Whether to include text color opacity in the snapshot (default: false). An element might have the opacity property set that affects the text color of the element. The final text color opacity is computed based on the opacity of all overlapping elements.
    */
    private Boolean includeTextColorOpacities;

    public void setComputedStyles (java.util.List<String> computedStyles) {
        this.computedStyles = computedStyles;
    }

    public java.util.List<String> getComputedStyles() {
        return this.computedStyles;
    }

    public void setIncludePaintOrder (Boolean includePaintOrder) {
        this.includePaintOrder = includePaintOrder;
    }

    public Boolean getIncludePaintOrder() {
        return this.includePaintOrder;
    }

    public void setIncludeDOMRects (Boolean includeDOMRects) {
        this.includeDOMRects = includeDOMRects;
    }

    public Boolean getIncludeDOMRects() {
        return this.includeDOMRects;
    }

    public void setIncludeBlendedBackgroundColors (Boolean includeBlendedBackgroundColors) {
        this.includeBlendedBackgroundColors = includeBlendedBackgroundColors;
    }

    public Boolean getIncludeBlendedBackgroundColors() {
        return this.includeBlendedBackgroundColors;
    }

    public void setIncludeTextColorOpacities (Boolean includeTextColorOpacities) {
        this.includeTextColorOpacities = includeTextColorOpacities;
    }

    public Boolean getIncludeTextColorOpacities() {
        return this.includeTextColorOpacities;
    }

    public CaptureSnapshotRequest(java.util.List<String> computedStyles, Boolean includePaintOrder, Boolean includeDOMRects, Boolean includeBlendedBackgroundColors, Boolean includeTextColorOpacities) {
        this.computedStyles = computedStyles;
        this.includePaintOrder = includePaintOrder;
        this.includeDOMRects = includeDOMRects;
        this.includeBlendedBackgroundColors = includeBlendedBackgroundColors;
        this.includeTextColorOpacities = includeTextColorOpacities;
    }

    public CaptureSnapshotRequest(java.util.List<String> computedStyles) {
        this.computedStyles = computedStyles;
        this.includePaintOrder = null;
        this.includeDOMRects = null;
        this.includeBlendedBackgroundColors = null;
        this.includeTextColorOpacities = null;
    }

    public CaptureSnapshotRequest() {
    }

}