package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetAttributesResponse {

    /**
    * An interleaved array of node attribute names and values.
    */
    public final java.util.List<String> attributes;

    public GetAttributesResponse(java.util.List<String> attributes) {
        this.attributes = attributes;
    }

}