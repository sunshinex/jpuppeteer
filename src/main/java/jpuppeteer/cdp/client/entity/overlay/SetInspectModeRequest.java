package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetInspectModeRequest {

    /**
    * Set an inspection mode.
    */
    public final String mode;

    /**
    * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if `enabled == false`.
    */
    public final jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig;

    public SetInspectModeRequest(String mode, jpuppeteer.cdp.client.entity.overlay.HighlightConfig highlightConfig) {
        this.mode = mode;
        this.highlightConfig = highlightConfig;
    }

    public SetInspectModeRequest(String mode) {
        this.mode = mode;
        this.highlightConfig = null;
    }

}