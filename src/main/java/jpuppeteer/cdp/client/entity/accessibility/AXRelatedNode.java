package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class AXRelatedNode {

    /**
    * The BackendNodeId of the related DOM node.
    */
    private Integer backendDOMNodeId;

    /**
    * The IDRef value provided, if any.
    */
    private String idref;

    /**
    * The text alternative of this node in the current context.
    */
    private String text;

    public void setBackendDOMNodeId (Integer backendDOMNodeId) {
        this.backendDOMNodeId = backendDOMNodeId;
    }

    public Integer getBackendDOMNodeId() {
        return this.backendDOMNodeId;
    }

    public void setIdref (String idref) {
        this.idref = idref;
    }

    public String getIdref() {
        return this.idref;
    }

    public void setText (String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public AXRelatedNode(Integer backendDOMNodeId, String idref, String text) {
        this.backendDOMNodeId = backendDOMNodeId;
        this.idref = idref;
        this.text = text;
    }

    public AXRelatedNode(Integer backendDOMNodeId) {
        this.backendDOMNodeId = backendDOMNodeId;
        this.idref = null;
        this.text = null;
    }

    public AXRelatedNode() {
    }

}