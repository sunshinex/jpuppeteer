package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetAttributesAsTextRequest {

    /**
    * Id of the element to set attributes for.
    */
    public final Integer nodeId;

    /**
    * Text with a number of attributes. Will parse this text using HTML parser.
    */
    public final String text;

    /**
    * Attribute name to replace with new attributes derived from text in case text parsed successfully.
    */
    public final String name;

    public SetAttributesAsTextRequest(Integer nodeId, String text, String name) {
        this.nodeId = nodeId;
        this.text = text;
        this.name = name;
    }

    public SetAttributesAsTextRequest(Integer nodeId, String text) {
        this.nodeId = nodeId;
        this.text = text;
        this.name = null;
    }

}