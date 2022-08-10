package jpuppeteer.cdp.client.entity.headlessexperimental;

/**
* Encoding options for a screenshot.
* experimental
*/
public class ScreenshotParams {

    /**
    * Image compression format (defaults to png).
    */
    private jpuppeteer.cdp.client.constant.headlessexperimental.ScreenshotParamsFormat format;

    /**
    * Compression quality from range [0..100] (jpeg only).
    */
    private Integer quality;

    public void setFormat (jpuppeteer.cdp.client.constant.headlessexperimental.ScreenshotParamsFormat format) {
        this.format = format;
    }

    public jpuppeteer.cdp.client.constant.headlessexperimental.ScreenshotParamsFormat getFormat() {
        return this.format;
    }

    public void setQuality (Integer quality) {
        this.quality = quality;
    }

    public Integer getQuality() {
        return this.quality;
    }

    public ScreenshotParams(jpuppeteer.cdp.client.constant.headlessexperimental.ScreenshotParamsFormat format, Integer quality) {
        this.format = format;
        this.quality = quality;
    }

    public ScreenshotParams() {
        this.format = null;
        this.quality = null;
    }

}