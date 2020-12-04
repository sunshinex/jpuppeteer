package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureScreenshotResponse {

    /**
    * Base64-encoded image data.
    */
    public final String data;

    public CaptureScreenshotResponse(String data) {
        this.data = data;
    }

}