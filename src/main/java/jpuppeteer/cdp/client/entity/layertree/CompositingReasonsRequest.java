package jpuppeteer.cdp.client.entity.layertree;

/**
* experimental
*/
public class CompositingReasonsRequest {

    /**
    * The id of the layer for which we want to get the reasons it was composited.
    */
    private String layerId;

    public void setLayerId (String layerId) {
        this.layerId = layerId;
    }

    public String getLayerId() {
        return this.layerId;
    }

    public CompositingReasonsRequest(String layerId) {
        this.layerId = layerId;
    }

    public CompositingReasonsRequest() {
    }

}