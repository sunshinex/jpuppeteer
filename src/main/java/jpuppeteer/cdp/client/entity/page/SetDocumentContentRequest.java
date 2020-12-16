package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetDocumentContentRequest {

    /**
    * Frame id to set HTML for.
    */
    public final String frameId;

    /**
    * HTML content to set.
    */
    public final String html;

    public SetDocumentContentRequest(String frameId, String html) {
        this.frameId = frameId;
        this.html = html;
    }

}