package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetBoxModelResponse {

    /**
    * Box model for the node.
    */
    public final jpuppeteer.cdp.client.entity.dom.BoxModel model;

    public GetBoxModelResponse(jpuppeteer.cdp.client.entity.dom.BoxModel model) {
        this.model = model;
    }

}