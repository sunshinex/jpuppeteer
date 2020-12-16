package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetBoxModelResponse {

    /**
    * Box model for the node.
    */
    public final BoxModel model;

    public GetBoxModelResponse(BoxModel model) {
        this.model = model;
    }

}