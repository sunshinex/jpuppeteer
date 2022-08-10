package jpuppeteer.cdp.client.entity.page;

/**
*/
public class GetResourceContentResponse {

    /**
    * Resource content.
    */
    private String content;

    /**
    * True, if content was served as base64.
    */
    private Boolean base64Encoded;

    public void setContent (String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setBase64Encoded (Boolean base64Encoded) {
        this.base64Encoded = base64Encoded;
    }

    public Boolean getBase64Encoded() {
        return this.base64Encoded;
    }

    public GetResourceContentResponse(String content, Boolean base64Encoded) {
        this.content = content;
        this.base64Encoded = base64Encoded;
    }

    public GetResourceContentResponse() {
    }

}