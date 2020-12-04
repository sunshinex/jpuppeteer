package jpuppeteer.cdp.client.entity.emulation;

/**
* Screen orientation.
*/
public class ScreenOrientation {

    /**
    * Orientation type.
    */
    public final String type;

    /**
    * Orientation angle.
    */
    public final Integer angle;

    public ScreenOrientation(String type, Integer angle) {
        this.type = type;
        this.angle = angle;
    }

}