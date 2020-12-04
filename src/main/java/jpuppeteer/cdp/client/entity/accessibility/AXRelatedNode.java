package jpuppeteer.cdp.client.entity.accessibility;

/**
* experimental
*/
public class AXRelatedNode {

    /**
    * The BackendNodeId of the related DOM node.
    */
    public final Integer backendDOMNodeId;

    /**
    * The IDRef value provided, if any.
    */
    public final String idref;

    /**
    * The text alternative of this node in the current context.
    */
    public final String text;

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

}