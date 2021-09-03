package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SetAcceptedEncodingsRequest {

    /**
    * List of accepted content encodings.
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.network.ContentEncoding> encodings;

    public SetAcceptedEncodingsRequest(java.util.List<jpuppeteer.cdp.client.constant.network.ContentEncoding> encodings) {
        this.encodings = encodings;
    }

}