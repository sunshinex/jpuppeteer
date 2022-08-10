package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class SetOuterHTMLRequest {

    /**
    * Id of the node to set markup for.
    */
    private Integer nodeId;

    /**
    * Outer HTML markup to set.
    */
    private String outerHTML;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setOuterHTML (String outerHTML) {
        this.outerHTML = outerHTML;
    }

    public String getOuterHTML() {
        return this.outerHTML;
    }

    public SetOuterHTMLRequest(Integer nodeId, String outerHTML) {
        this.nodeId = nodeId;
        this.outerHTML = outerHTML;
    }

    public SetOuterHTMLRequest() {
    }

}