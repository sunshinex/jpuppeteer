package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetAttributesAsTextRequest {

    /**
    * Id of the element to set attributes for.
    */
    private Integer nodeId;

    /**
    * Text with a number of attributes. Will parse this text using HTML parser.
    */
    private String text;

    /**
    * Attribute name to replace with new attributes derived from text in case text parsed successfully.
    */
    private String name;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

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

    public SetAttributesAsTextRequest() {
    }

}