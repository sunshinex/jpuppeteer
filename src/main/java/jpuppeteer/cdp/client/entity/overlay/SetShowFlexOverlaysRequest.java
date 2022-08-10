package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowFlexOverlaysRequest {

    /**
    * An array of node identifiers and descriptors for the highlight appearance.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.overlay.FlexNodeHighlightConfig> flexNodeHighlightConfigs;

    public void setFlexNodeHighlightConfigs (java.util.List<jpuppeteer.cdp.client.entity.overlay.FlexNodeHighlightConfig> flexNodeHighlightConfigs) {
        this.flexNodeHighlightConfigs = flexNodeHighlightConfigs;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.overlay.FlexNodeHighlightConfig> getFlexNodeHighlightConfigs() {
        return this.flexNodeHighlightConfigs;
    }

    public SetShowFlexOverlaysRequest(java.util.List<jpuppeteer.cdp.client.entity.overlay.FlexNodeHighlightConfig> flexNodeHighlightConfigs) {
        this.flexNodeHighlightConfigs = flexNodeHighlightConfigs;
    }

    public SetShowFlexOverlaysRequest() {
    }

}