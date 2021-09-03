package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureScreenshotRequest {

    /**
    * Image compression format (defaults to png).
    */
    public final jpuppeteer.cdp.client.constant.page.CaptureScreenshotRequestFormat format;

    /**
    * Compression quality from range [0..100] (jpeg only).
    */
    public final Integer quality;

    /**
    * Capture the screenshot of a given region only.
    */
    public final jpuppeteer.cdp.client.entity.page.Viewport clip;

    /**
    * Capture the screenshot from the surface, rather than the view. Defaults to true.
    */
    public final Boolean fromSurface;

    /**
    * Capture the screenshot beyond the viewport. Defaults to false.
    */
    public final Boolean captureBeyondViewport;

    public CaptureScreenshotRequest(jpuppeteer.cdp.client.constant.page.CaptureScreenshotRequestFormat format, Integer quality, jpuppeteer.cdp.client.entity.page.Viewport clip, Boolean fromSurface, Boolean captureBeyondViewport) {
        this.format = format;
        this.quality = quality;
        this.clip = clip;
        this.fromSurface = fromSurface;
        this.captureBeyondViewport = captureBeyondViewport;
    }

    public CaptureScreenshotRequest() {
        this.format = null;
        this.quality = null;
        this.clip = null;
        this.fromSurface = null;
        this.captureBeyondViewport = null;
    }

}