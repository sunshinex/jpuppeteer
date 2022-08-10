package jpuppeteer.cdp.client.entity.emulation;

/**
* Screen orientation.
*/
public class ScreenOrientation {

    /**
    * Orientation type.
    */
    private jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType type;

    /**
    * Orientation angle.
    */
    private Integer angle;

    public void setType (jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType getType() {
        return this.type;
    }

    public void setAngle (Integer angle) {
        this.angle = angle;
    }

    public Integer getAngle() {
        return this.angle;
    }

    public ScreenOrientation(jpuppeteer.cdp.client.constant.emulation.ScreenOrientationType type, Integer angle) {
        this.type = type;
        this.angle = angle;
    }

    public ScreenOrientation() {
    }

}