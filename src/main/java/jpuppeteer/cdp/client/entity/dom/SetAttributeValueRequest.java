package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetAttributeValueRequest {

    /**
    * Id of the element to set attribute for.
    */
    public final Integer nodeId;

    /**
    * Attribute name.
    */
    public final String name;

    /**
    * Attribute value.
    */
    public final String value;

    public SetAttributeValueRequest(Integer nodeId, String name, String value) {
        this.nodeId = nodeId;
        this.name = name;
        this.value = value;
    }

}