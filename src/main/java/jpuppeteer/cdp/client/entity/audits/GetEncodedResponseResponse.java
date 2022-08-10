package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class GetEncodedResponseResponse {

    /**
    * The encoded body as a base64 string. Omitted if sizeOnly is true. (Encoded as a base64 string when passed over JSON)
    */
    private String body;

    /**
    * Size before re-encoding.
    */
    private Integer originalSize;

    /**
    * Size after re-encoding.
    */
    private Integer encodedSize;

    public void setBody (String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

    public void setOriginalSize (Integer originalSize) {
        this.originalSize = originalSize;
    }

    public Integer getOriginalSize() {
        return this.originalSize;
    }

    public void setEncodedSize (Integer encodedSize) {
        this.encodedSize = encodedSize;
    }

    public Integer getEncodedSize() {
        return this.encodedSize;
    }

    public GetEncodedResponseResponse(String body, Integer originalSize, Integer encodedSize) {
        this.body = body;
        this.originalSize = originalSize;
        this.encodedSize = encodedSize;
    }

    public GetEncodedResponseResponse(Integer originalSize, Integer encodedSize) {
        this.body = null;
        this.originalSize = originalSize;
        this.encodedSize = encodedSize;
    }

    public GetEncodedResponseResponse() {
    }

}