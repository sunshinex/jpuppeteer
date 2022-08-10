package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class GetResponseBodyResponse {

    /**
    * Response body.
    */
    private String body;

    /**
    * True, if content was sent as base64.
    */
    private Boolean base64Encoded;

    public void setBody (String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

    public void setBase64Encoded (Boolean base64Encoded) {
        this.base64Encoded = base64Encoded;
    }

    public Boolean getBase64Encoded() {
        return this.base64Encoded;
    }

    public GetResponseBodyResponse(String body, Boolean base64Encoded) {
        this.body = body;
        this.base64Encoded = base64Encoded;
    }

    public GetResponseBodyResponse() {
    }

}