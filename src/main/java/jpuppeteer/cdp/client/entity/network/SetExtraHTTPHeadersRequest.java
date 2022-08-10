package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetExtraHTTPHeadersRequest {

    /**
    * Map with extra HTTP headers.
    */
    private java.util.Map<String, Object> headers;

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public SetExtraHTTPHeadersRequest(java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public SetExtraHTTPHeadersRequest() {
    }

}