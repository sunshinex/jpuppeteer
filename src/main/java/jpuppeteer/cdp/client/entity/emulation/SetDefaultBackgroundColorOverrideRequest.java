package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetDefaultBackgroundColorOverrideRequest {

    /**
    * RGBA of the default background color. If not specified, any existing override will be cleared.
    */
    private jpuppeteer.cdp.client.entity.dom.RGBA color;

    public void setColor (jpuppeteer.cdp.client.entity.dom.RGBA color) {
        this.color = color;
    }

    public jpuppeteer.cdp.client.entity.dom.RGBA getColor() {
        return this.color;
    }

    public SetDefaultBackgroundColorOverrideRequest(jpuppeteer.cdp.client.entity.dom.RGBA color) {
        this.color = color;
    }

    public SetDefaultBackgroundColorOverrideRequest() {
        this.color = null;
    }

}