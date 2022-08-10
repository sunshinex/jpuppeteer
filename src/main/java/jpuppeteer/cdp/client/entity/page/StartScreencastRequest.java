package jpuppeteer.cdp.client.entity.page;

/**
*/
public class StartScreencastRequest {

    /**
    * Image compression format.
    */
    private jpuppeteer.cdp.client.constant.page.StartScreencastRequestFormat format;

    /**
    * Compression quality from range [0..100].
    */
    private Integer quality;

    /**
    * Maximum screenshot width.
    */
    private Integer maxWidth;

    /**
    * Maximum screenshot height.
    */
    private Integer maxHeight;

    /**
    * Send every n-th frame.
    */
    private Integer everyNthFrame;

    public void setFormat (jpuppeteer.cdp.client.constant.page.StartScreencastRequestFormat format) {
        this.format = format;
    }

    public jpuppeteer.cdp.client.constant.page.StartScreencastRequestFormat getFormat() {
        return this.format;
    }

    public void setQuality (Integer quality) {
        this.quality = quality;
    }

    public Integer getQuality() {
        return this.quality;
    }

    public void setMaxWidth (Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Integer getMaxWidth() {
        return this.maxWidth;
    }

    public void setMaxHeight (Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Integer getMaxHeight() {
        return this.maxHeight;
    }

    public void setEveryNthFrame (Integer everyNthFrame) {
        this.everyNthFrame = everyNthFrame;
    }

    public Integer getEveryNthFrame() {
        return this.everyNthFrame;
    }

    public StartScreencastRequest(jpuppeteer.cdp.client.constant.page.StartScreencastRequestFormat format, Integer quality, Integer maxWidth, Integer maxHeight, Integer everyNthFrame) {
        this.format = format;
        this.quality = quality;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.everyNthFrame = everyNthFrame;
    }

    public StartScreencastRequest() {
        this.format = null;
        this.quality = null;
        this.maxWidth = null;
        this.maxHeight = null;
        this.everyNthFrame = null;
    }

}