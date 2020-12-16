package jpuppeteer.cdp.client.entity.page;

/**
*/
public class StartScreencastRequest {

    /**
    * Image compression format.
    */
    public final jpuppeteer.cdp.client.constant.page.StartScreencastRequestFormat format;

    /**
    * Compression quality from range [0..100].
    */
    public final Integer quality;

    /**
    * Maximum screenshot width.
    */
    public final Integer maxWidth;

    /**
    * Maximum screenshot height.
    */
    public final Integer maxHeight;

    /**
    * Send every n-th frame.
    */
    public final Integer everyNthFrame;

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