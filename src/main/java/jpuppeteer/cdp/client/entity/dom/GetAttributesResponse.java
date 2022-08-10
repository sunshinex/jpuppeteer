package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetAttributesResponse {

    /**
    * An interleaved array of node attribute names and values.
    */
    private java.util.List<String> attributes;

    public void setAttributes (java.util.List<String> attributes) {
        this.attributes = attributes;
    }

    public java.util.List<String> getAttributes() {
        return this.attributes;
    }

    public GetAttributesResponse(java.util.List<String> attributes) {
        this.attributes = attributes;
    }

    public GetAttributesResponse() {
    }

}