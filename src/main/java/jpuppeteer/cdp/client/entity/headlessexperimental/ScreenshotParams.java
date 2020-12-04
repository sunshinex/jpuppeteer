package jpuppeteer.cdp.client.entity.headlessexperimental;

/**
* Encoding options for a screenshot.
* experimental
*/
public class ScreenshotParams {

    /**
    * Image compression format (defaults to png).
    */
    public final String format;

    /**
    * Compression quality from range [0..100] (jpeg only).
    */
    public final Integer quality;

    public ScreenshotParams(String format, Integer quality) {
        this.format = format;
        this.quality = quality;
    }

    public ScreenshotParams() {
        this.format = null;
        this.quality = null;
    }

}