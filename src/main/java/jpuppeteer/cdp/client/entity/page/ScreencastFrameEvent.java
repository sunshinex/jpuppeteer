package jpuppeteer.cdp.client.entity.page;

/**
* Compressed image data requested by the `startScreencast`.
*/
public class ScreencastFrameEvent {

    /**
    * Base64-encoded compressed image.
    */
    public final String data;

    /**
    * Screencast frame metadata.
    */
    public final jpuppeteer.cdp.client.entity.page.ScreencastFrameMetadata metadata;

    /**
    * Frame number.
    */
    public final Integer sessionId;

    public ScreencastFrameEvent(String data, jpuppeteer.cdp.client.entity.page.ScreencastFrameMetadata metadata, Integer sessionId) {
        this.data = data;
        this.metadata = metadata;
        this.sessionId = sessionId;
    }

}