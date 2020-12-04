package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightFrameRequest {

    /**
    * Identifier of the frame to highlight.
    */
    public final String frameId;

    /**
    * The content box highlight fill color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA contentColor;

    /**
    * The content box highlight outline color (default: transparent).
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA contentOutlineColor;

    public HighlightFrameRequest(String frameId, jpuppeteer.cdp.client.entity.dom.RGBA contentColor, jpuppeteer.cdp.client.entity.dom.RGBA contentOutlineColor) {
        this.frameId = frameId;
        this.contentColor = contentColor;
        this.contentOutlineColor = contentOutlineColor;
    }

    public HighlightFrameRequest(String frameId) {
        this.frameId = frameId;
        this.contentColor = null;
        this.contentOutlineColor = null;
    }

}