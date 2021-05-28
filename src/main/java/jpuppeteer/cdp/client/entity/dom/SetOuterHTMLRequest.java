package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetOuterHTMLRequest {

    /**
    * Id of the node to set markup for.
    */
    public final Integer nodeId;

    /**
    * Outer HTML markup to set.
    */
    public final String outerHTML;

    public SetOuterHTMLRequest(Integer nodeId, String outerHTML) {
        this.nodeId = nodeId;
        this.outerHTML = outerHTML;
    }

}