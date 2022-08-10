package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetAcceptedEncodingsRequest {

    /**
    * List of accepted content encodings.
    */
    private java.util.List<jpuppeteer.cdp.client.constant.network.ContentEncoding> encodings;

    public void setEncodings (java.util.List<jpuppeteer.cdp.client.constant.network.ContentEncoding> encodings) {
        this.encodings = encodings;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.network.ContentEncoding> getEncodings() {
        return this.encodings;
    }

    public SetAcceptedEncodingsRequest(java.util.List<jpuppeteer.cdp.client.constant.network.ContentEncoding> encodings) {
        this.encodings = encodings;
    }

    public SetAcceptedEncodingsRequest() {
    }

}