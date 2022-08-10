package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetDisabledImageTypesRequest {

    /**
    * Image types to disable.
    */
    private java.util.List<jpuppeteer.cdp.client.constant.emulation.DisabledImageType> imageTypes;

    public void setImageTypes (java.util.List<jpuppeteer.cdp.client.constant.emulation.DisabledImageType> imageTypes) {
        this.imageTypes = imageTypes;
    }

    public java.util.List<jpuppeteer.cdp.client.constant.emulation.DisabledImageType> getImageTypes() {
        return this.imageTypes;
    }

    public SetDisabledImageTypesRequest(java.util.List<jpuppeteer.cdp.client.constant.emulation.DisabledImageType> imageTypes) {
        this.imageTypes = imageTypes;
    }

    public SetDisabledImageTypesRequest() {
    }

}