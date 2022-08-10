package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class HighlightFrameRequest {

    /**
    * Identifier of the frame to highlight.
    */
    private String frameId;

    /**
    * The content box highlight fill color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA contentColor;

    /**
    * The content box highlight outline color (default: transparent).
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA contentOutlineColor;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setContentColor (jpuppeteer.cdp.client.entity.dom.RGBA contentColor) {
        this.contentColor = contentColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getContentColor() {
        return this.contentColor;
    }

    public void setContentOutlineColor (jpuppeteer.cdp.client.entity.dom.RGBA contentOutlineColor) {
        this.contentOutlineColor = contentOutlineColor;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getContentOutlineColor() {
        return this.contentOutlineColor;
    }

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

    public HighlightFrameRequest() {
    }

}