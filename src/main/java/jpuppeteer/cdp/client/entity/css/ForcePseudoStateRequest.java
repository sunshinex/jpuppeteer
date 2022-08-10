package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class ForcePseudoStateRequest {

    /**
    * The element id for which to force the pseudo state.
    */
    private Integer nodeId;

    /**
    * Element pseudo classes to force when computing the element's style.
    */
    private java.util.List<String> forcedPseudoClasses;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setForcedPseudoClasses (java.util.List<String> forcedPseudoClasses) {
        this.forcedPseudoClasses = forcedPseudoClasses;
    }

    public java.util.List<String> getForcedPseudoClasses() {
        return this.forcedPseudoClasses;
    }

    public ForcePseudoStateRequest(Integer nodeId, java.util.List<String> forcedPseudoClasses) {
        this.nodeId = nodeId;
        this.forcedPseudoClasses = forcedPseudoClasses;
    }

    public ForcePseudoStateRequest() {
    }

}