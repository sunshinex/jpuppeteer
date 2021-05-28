package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class GetEncodedResponseResponse {

    /**
    * The encoded body as a base64 string. Omitted if sizeOnly is true. (Encoded as a base64 string when passed over JSON)
    */
    public final String body;

    /**
    * Size before re-encoding.
    */
    public final Integer originalSize;

    /**
    * Size after re-encoding.
    */
    public final Integer encodedSize;

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

}