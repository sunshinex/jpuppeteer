package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureScreenshotRequest {

    /**
    * Image compression format (defaults to png).
    */
    private jpuppeteer.cdp.client.constant.page.CaptureScreenshotRequestFormat format;

    /**
    * Compression quality from range [0..100] (jpeg only).
    */
    private Integer quality;

    /**
    * Capture the screenshot of a given region only.
    */
    private jpuppeteer.cdp.client.entity.page.Viewport clip;

    /**
    * Capture the screenshot from the surface, rather than the view. Defaults to true.
    */
    private Boolean fromSurface;

    /**
    * Capture the screenshot beyond the viewport. Defaults to false.
    */
    private Boolean captureBeyondViewport;

    public void setFormat (jpuppeteer.cdp.client.constant.page.CaptureScreenshotRequestFormat format) {
        this.format = format;
    }

    public jpuppeteer.cdp.client.constant.page.CaptureScreenshotRequestFormat getFormat() {
        return this.format;
    }

    public void setQuality (Integer quality) {
        this.quality = quality;
    }

    public Integer getQuality() {
        return this.quality;
    }

    public void setClip (jpuppeteer.cdp.client.entity.page.Viewport clip) {
        this.clip = clip;
    }

    public jpuppeteer.cdp.client.entity.page.Viewport getClip() {
        return this.clip;
    }

    public void setFromSurface (Boolean fromSurface) {
        this.fromSurface = fromSurface;
    }

    public Boolean getFromSurface() {
        return this.fromSurface;
    }

    public void setCaptureBeyondViewport (Boolean captureBeyondViewport) {
        this.captureBeyondViewport = captureBeyondViewport;
    }

    public Boolean getCaptureBeyondViewport() {
        return this.captureBeyondViewport;
    }

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