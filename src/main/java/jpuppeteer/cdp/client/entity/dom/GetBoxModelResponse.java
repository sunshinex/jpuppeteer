package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetBoxModelResponse {

    /**
    * Box model for the node.
    */
    private jpuppeteer.cdp.client.entity.dom.BoxModel model;

    public void setModel (jpuppeteer.cdp.client.entity.dom.BoxModel model) {
        this.model = model;
    }

    public jpuppeteer.cdp.client.entity.dom.BoxModel getModel() {
        return this.model;
    }

    public GetBoxModelResponse(jpuppeteer.cdp.client.entity.dom.BoxModel model) {
        this.model = model;
    }

    public GetBoxModelResponse() {
    }

}