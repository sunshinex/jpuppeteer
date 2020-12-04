package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class CompositingReasonsRequest {

    /**
    * The id of the layer for which we want to get the reasons it was composited.
    */
    public final String layerId;

    public CompositingReasonsRequest(String layerId) {
        this.layerId = layerId;
    }

}