package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetResponseBodyForInterceptionResponse {

    /**
    * Response body.
    */
    public final String body;

    /**
    * True, if content was sent as base64.
    */
    public final Boolean base64Encoded;

    public GetResponseBodyForInterceptionResponse(String body, Boolean base64Encoded) {
        this.body = body;
        this.base64Encoded = base64Encoded;
    }

}