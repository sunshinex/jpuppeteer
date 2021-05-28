package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureScreenshotResponse {

    /**
    * Base64-encoded image data. (Encoded as a base64 string when passed over JSON)
    */
    public final String data;

    public CaptureScreenshotResponse(String data) {
        this.data = data;
    }

}