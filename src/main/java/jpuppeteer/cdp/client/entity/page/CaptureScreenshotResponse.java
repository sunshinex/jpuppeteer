package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureScreenshotResponse {

    /**
    * Base64-encoded image data. (Encoded as a base64 string when passed over JSON)
    */
    private String data;

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public CaptureScreenshotResponse(String data) {
        this.data = data;
    }

    public CaptureScreenshotResponse() {
    }

}