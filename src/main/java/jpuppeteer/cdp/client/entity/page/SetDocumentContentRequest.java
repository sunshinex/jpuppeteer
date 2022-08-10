package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetDocumentContentRequest {

    /**
    * Frame id to set HTML for.
    */
    private String frameId;

    /**
    * HTML content to set.
    */
    private String html;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setHtml (String html) {
        this.html = html;
    }

    public String getHtml() {
        return this.html;
    }

    public SetDocumentContentRequest(String frameId, String html) {
        this.frameId = frameId;
        this.html = html;
    }

    public SetDocumentContentRequest() {
    }

}