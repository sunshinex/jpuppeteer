package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetResourceContentResponse {

    /**
    * Resource content.
    */
    public final String content;

    /**
    * True, if content was served as base64.
    */
    public final Boolean base64Encoded;

    public GetResourceContentResponse(String content, Boolean base64Encoded) {
        this.content = content;
        this.base64Encoded = base64Encoded;
    }

}