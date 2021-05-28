package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetDisabledImageTypesRequest {

    /**
    * Image types to disable.
    */
    public final java.util.List<jpuppeteer.cdp.client.constant.emulation.DisabledImageType> imageTypes;

    public SetDisabledImageTypesRequest(java.util.List<jpuppeteer.cdp.client.constant.emulation.DisabledImageType> imageTypes) {
        this.imageTypes = imageTypes;
    }

}