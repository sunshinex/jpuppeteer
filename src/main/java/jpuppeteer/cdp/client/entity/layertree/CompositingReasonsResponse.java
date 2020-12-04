package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class CompositingReasonsResponse {

    /**
    * A list of strings specifying reasons for the given layer to become composited.
    */
    public final java.util.List<String> compositingReasons;

    public CompositingReasonsResponse(java.util.List<String> compositingReasons) {
        this.compositingReasons = compositingReasons;
    }

}