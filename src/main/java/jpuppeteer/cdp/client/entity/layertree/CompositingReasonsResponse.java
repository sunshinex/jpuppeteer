package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class CompositingReasonsResponse {

    /**
    * A list of strings specifying reasons for the given layer to become composited.
    */
    public final java.util.List<String> compositingReasons;

    /**
    * A list of strings specifying reason IDs for the given layer to become composited.
    */
    public final java.util.List<String> compositingReasonIds;

    public CompositingReasonsResponse(java.util.List<String> compositingReasons, java.util.List<String> compositingReasonIds) {
        this.compositingReasons = compositingReasons;
        this.compositingReasonIds = compositingReasonIds;
    }

}