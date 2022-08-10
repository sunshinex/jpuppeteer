package jpuppeteer.cdp.client.entity.page;

/**
* Compressed image data requested by the `startScreencast`.
*/
public class ScreencastFrameEvent {

    /**
    * Base64-encoded compressed image. (Encoded as a base64 string when passed over JSON)
    */
    private String data;

    /**
    * Screencast frame metadata.
    */
    private jpuppeteer.cdp.client.entity.page.ScreencastFrameMetadata metadata;

    /**
    * Frame number.
    */
    private Integer sessionId;

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void setMetadata (jpuppeteer.cdp.client.entity.page.ScreencastFrameMetadata metadata) {
        this.metadata = metadata;
    }

    public jpuppeteer.cdp.client.entity.page.ScreencastFrameMetadata getMetadata() {
        return this.metadata;
    }

    public void setSessionId (Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getSessionId() {
        return this.sessionId;
    }

    public ScreencastFrameEvent(String data, jpuppeteer.cdp.client.entity.page.ScreencastFrameMetadata metadata, Integer sessionId) {
        this.data = data;
        this.metadata = metadata;
        this.sessionId = sessionId;
    }

    public ScreencastFrameEvent() {
    }

}