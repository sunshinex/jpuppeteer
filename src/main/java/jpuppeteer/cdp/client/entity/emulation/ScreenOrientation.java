package jpuppeteer.cdp.client.entity.emulation;

/**
* Screen orientation.
*/
public class ScreenOrientation {

    /**
    * Orientation type.
    */
    public final jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType type;

    /**
    * Orientation angle.
    */
    public final Integer angle;

    public ScreenOrientation(jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType type, Integer angle) {
        this.type = type;
        this.angle = angle;
    }

}