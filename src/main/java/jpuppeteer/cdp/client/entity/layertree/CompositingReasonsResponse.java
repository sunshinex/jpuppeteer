package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class CompositingReasonsResponse {

    /**
    * A list of strings specifying reasons for the given layer to become composited.
    */
    private java.util.List<String> compositingReasons;

    /**
    * A list of strings specifying reason IDs for the given layer to become composited.
    */
    private java.util.List<String> compositingReasonIds;

    public void setCompositingReasons (java.util.List<String> compositingReasons) {
        this.compositingReasons = compositingReasons;
    }

    public java.util.List<String> getCompositingReasons() {
        return this.compositingReasons;
    }

    public void setCompositingReasonIds (java.util.List<String> compositingReasonIds) {
        this.compositingReasonIds = compositingReasonIds;
    }

    public java.util.List<String> getCompositingReasonIds() {
        return this.compositingReasonIds;
    }

    public CompositingReasonsResponse(java.util.List<String> compositingReasons, java.util.List<String> compositingReasonIds) {
        this.compositingReasons = compositingReasons;
        this.compositingReasonIds = compositingReasonIds;
    }

    public CompositingReasonsResponse() {
    }

}