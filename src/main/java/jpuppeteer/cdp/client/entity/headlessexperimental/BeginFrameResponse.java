package jpuppeteer.cdp.client.entity.headlessexperimental;

/**
* experimental
*/
public class BeginFrameResponse {

    /**
    * Whether the BeginFrame resulted in damage and, thus, a new frame was committed to the display. Reported for diagnostic uses, may be removed in the future.
    */
    private Boolean hasDamage;

    /**
    * Base64-encoded image data of the screenshot, if one was requested and successfully taken. (Encoded as a base64 string when passed over JSON)
    */
    private String screenshotData;

    public void setHasDamage (Boolean hasDamage) {
        this.hasDamage = hasDamage;
    }

    public Boolean getHasDamage() {
        return this.hasDamage;
    }

    public void setScreenshotData (String screenshotData) {
        this.screenshotData = screenshotData;
    }

    public String getScreenshotData() {
        return this.screenshotData;
    }

    public BeginFrameResponse(Boolean hasDamage, String screenshotData) {
        this.hasDamage = hasDamage;
        this.screenshotData = screenshotData;
    }

    public BeginFrameResponse(Boolean hasDamage) {
        this.hasDamage = hasDamage;
        this.screenshotData = null;
    }

    public BeginFrameResponse() {
    }

}