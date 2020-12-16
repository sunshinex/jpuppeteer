package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetInspectModeRequest {

    /**
    * Set an inspection mode.
    */
    public final jpuppeteer.cdp.client.constant.overlay.InspectMode mode;

    /**
    * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if `enabled == false`.
    */
    public final HighlightConfig highlightConfig;

    public SetInspectModeRequest(jpuppeteer.cdp.client.constant.overlay.InspectMode mode, HighlightConfig highlightConfig) {
        this.mode = mode;
        this.highlightConfig = highlightConfig;
    }

    public SetInspectModeRequest(jpuppeteer.cdp.client.constant.overlay.InspectMode mode) {
        this.mode = mode;
        this.highlightConfig = null;
    }

}