package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetDefaultBackgroundColorOverrideRequest {

    /**
    * RGBA of the default background color. If not specified, any existing override will be cleared.
    */
    public final jpuppeteer.cdp.client.entity.dom.RGBA color;

    public SetDefaultBackgroundColorOverrideRequest(jpuppeteer.cdp.client.entity.dom.RGBA color) {
        this.color = color;
    }

    public SetDefaultBackgroundColorOverrideRequest() {
        this.color = null;
    }

}