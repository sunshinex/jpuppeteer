package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetInspectModeRequest {

    /**
    * Set an inspection mode.
    */
    private jpuppeteer.cdp.client.constant.overlay.InspectMode mode;

    /**
    * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if `enabled == false`.
    */
    private jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig;

    public void setMode (jpuppeteer.cdp.client.constant.overlay.InspectMode mode) {
        this.mode = mode;
    }

    public jpuppeteer.cdp.client.constant.overlay.InspectMode getMode() {
        return this.mode;
    }

    public void setHighlightConfig (jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig) {
        this.highlightConfig = highlightConfig;
    }

    public jpuppeteer.cdp.client.entity.overlay.HighlightConfig getHighlightConfig() {
        return this.highlightConfig;
    }

    public SetInspectModeRequest(jpuppeteer.cdp.client.constant.overlay.InspectMode mode, jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig) {
        this.mode = mode;
        this.highlightConfig = highlightConfig;
    }

    public SetInspectModeRequest(jpuppeteer.cdp.client.constant.overlay.InspectMode mode) {
        this.mode = mode;
        this.highlightConfig = null;
    }

    public SetInspectModeRequest() {
    }

}