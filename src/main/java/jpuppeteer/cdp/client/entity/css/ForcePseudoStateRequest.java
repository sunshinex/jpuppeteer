package jpuppeteer.cdp.client.entity.css;

/**
* experimental
*/
public class ForcePseudoStateRequest {

    /**
    * The element id for which to force the pseudo state.
    */
    public final Integer nodeId;

    /**
    * Element pseudo classes to force when computing the element's style.
    */
    public final java.util.List<String> forcedPseudoClasses;

    public ForcePseudoStateRequest(Integer nodeId, java.util.List<String> forcedPseudoClasses) {
        this.nodeId = nodeId;
        this.forcedPseudoClasses = forcedPseudoClasses;
    }

}